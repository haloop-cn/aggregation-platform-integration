package cn.haloop.intg.client;

import java.net.URI;
import lombok.Getter;
import lombok.Setter;

/**
 * 客户端配置
 *
 * @author yangtuo
 */
@Getter
@Setter
public class AggClientConfiguration {

  /**
   * 服务地址
   */
  private URI endpoint;

  /**
   * appKey, 用于应用标识
   */
  private String appKey;

  /**
   * appSecret, 用于应用认证
   */
  private String appSecret;
}
