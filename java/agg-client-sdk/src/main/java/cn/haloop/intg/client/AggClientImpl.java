package cn.haloop.intg.client;

import cn.haloop.intg.AggMessageException;
import cn.haloop.intg.client.digest.AggDigest;
import cn.haloop.intg.client.digest.AggDigester;
import cn.haloop.intg.collect.CluePushRequest;
import cn.haloop.intg.collect.CluePushResponse;
import cn.haloop.intg.collect.ClueUpdateRequest;
import cn.haloop.intg.collect.ClueUpdateResponse;
import cn.haloop.intg.improve.ClueImproveRequest;
import cn.haloop.intg.improve.ClueImproveResponse;
import cn.haloop.intg.serializer.AggSerializer;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import lombok.RequiredArgsConstructor;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yangtuo
 */
@RequiredArgsConstructor
public class AggClientImpl implements AggClient {

  private static final Logger log = LoggerFactory.getLogger(AggClientImpl.class);

  private final AggClientConfiguration config;
  private final AggSerializer serializer;
  private final CloseableHttpClient client;
  private final AggDigester digester;


  @Override
  public CluePushResponse push(CluePushRequest request) throws Exception {
    return send(request, CluePushResponse.class);
  }

  @Override
  public ClueUpdateResponse update(ClueUpdateRequest request) throws Exception {
    return send(request, ClueUpdateResponse.class);
  }

  @Override
  public ClueImproveResponse improve(ClueImproveRequest request) throws Exception {
    return send(request, ClueImproveResponse.class);
  }

  private <R extends BaseResponse<?>> R send(BaseRequest<?> request, Class<R> clz) throws Exception {

    URI target = new URIBuilder(config.getEndpoint())
        .setPathSegments(request.pathSegments())
        .build();

    String payload = serializer.serialize(request.getData());
    if (log.isDebugEnabled()) {
      log.debug("request: {}", payload);
    }

    AggDigest digest = digester.digest();
    if (log.isDebugEnabled()) {
      log.debug("digest: {}", serializer.serialize(digest));
    }

    HttpUriRequest post = RequestBuilder.post(target)
        .addHeader("appKey", config.getAppKey())
        .addHeader("nonce", digest.getNonce().toString())
        .addHeader("timestamp", digest.getTimestamp().toString())
        .addHeader("sign", digest.getDigest())
        .addHeader("requestId", request.getRequestId().toString())
        .addHeader("Content-Type", "application/json;charset=utf-8")
        .setEntity(new StringEntity(payload, StandardCharsets.UTF_8))
        .build();

    return client.execute(post, response -> {

      StatusLine sl = response.getStatusLine();
      String responseEntity = EntityUtils.toString(response.getEntity());
      int statusCode = sl.getStatusCode();
      if (statusCode >= 200 && statusCode < 300) {
        if (log.isDebugEnabled()) {
          log.debug("response: {}", responseEntity);
        }
        R res = serializer.deserialize(responseEntity, clz);
        if (!res.isSuccess()) {
          throw AggMessageException.of(request.getRequestId(), res.getCode(), res.getMsg());
        }
        return res;
      }
      log.error("request failed, status: {}, response: {}", statusCode, responseEntity);
      throw new IOException("request failed: " + sl);
    });
  }
}
