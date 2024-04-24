package cn.haloop.intg.client.digest;

import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author yangtuo
 */
@RequiredArgsConstructor
public class DefaultMD5AggDigester implements AggDigester {

  private final String appKey;
  private final String appSecret;
  private final Random random = new Random();

  @Override
  public AggDigest digest() {

    Long timestamp = getTimestamp();
    Long nonce = getNonce();
    String pattern = "appkey=%s&nonce=%d&timestamp=%d&appsecret=%s";
    String candidate = String.format(pattern, appKey, nonce, timestamp, appSecret);
    String digest = DigestUtils.md5Hex(candidate);
    return new AggDigest(digest, timestamp, nonce, appKey, appSecret);
  }

  private Long getTimestamp() {
    // 获取当前的秒级时间戳
    return System.currentTimeMillis() / 1000;
  }

  public Long getNonce() {
    // 生成6位随机数
    return random.nextInt(900000) + 100000L;
  }
}
