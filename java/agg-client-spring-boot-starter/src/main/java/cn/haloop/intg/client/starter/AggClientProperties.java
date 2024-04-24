package cn.haloop.intg.client.starter;

import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author yangtuo
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "agg.client")
public class AggClientProperties {

  /**
   * 是否启用
   */
  private Boolean enabled = true;

  /**
   * 服务地址
   */
  private URI endpoint;

  /**
   * appKey
   */
  private String appKey;

  /**
   * appSecret
   */
  private String appSecret;

}
