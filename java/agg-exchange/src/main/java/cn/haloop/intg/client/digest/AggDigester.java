package cn.haloop.intg.client.digest;

/**
 * 摘要生成
 *
 * @author yangtuo
 */
public interface AggDigester {

  /**
   * 生成摘要
   *
   * @return 摘要信息
   */
  AggDigest digest();
}
