package cn.haloop.intg.client.digest;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 摘要信息
 *
 * @author yangtuo
 */
@Getter
@RequiredArgsConstructor
public class AggDigest {

  /**
   * 摘要信息，根据规则生成的签名摘要
   */
  private final String digest;

  /**
   * 时间戳，生成摘要时的时间戳
   */
  private final Long timestamp;

  /**
   * 随机数，生成摘要时的随机数
   */
  private final Long nonce;

  /**
   * appKey, 生成摘要时使用的appKey
   */
  private final String appKey;

  /**
   * appSecret，生成摘要时使用的appSecret
   */
  private final String appSecret;

}
