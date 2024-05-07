package cn.haloop.intg.client;

import cn.haloop.intg.client.digest.MD5AggDigester;
import cn.haloop.intg.serializer.AggSerializerFactory;
import lombok.RequiredArgsConstructor;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * @author yangtuo
 */
@RequiredArgsConstructor
public class AggClientFactoryImpl implements AggClientFactory {

  private final AggSerializerFactory sf;

  @Override
  public AggClient create(AggClientConfiguration config) {
    CloseableHttpClient httpClient = HttpClients.createDefault();
    MD5AggDigester digester = new MD5AggDigester(config.getAppKey(), config.getAppSecret());
    return new AggClientImpl(config, sf.create(), httpClient, digester);
  }
}
