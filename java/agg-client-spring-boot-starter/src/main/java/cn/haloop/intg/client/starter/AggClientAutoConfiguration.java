package cn.haloop.intg.client.starter;

import cn.haloop.intg.client.AggClient;
import cn.haloop.intg.client.AggClientConfiguration;
import cn.haloop.intg.client.AggClientImpl;
import cn.haloop.intg.client.digest.AggDigester;
import cn.haloop.intg.client.digest.MD5AggDigester;
import cn.haloop.intg.serializer.AggSerializerFactory;
import lombok.RequiredArgsConstructor;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yangtuo
 */
@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(AggClientProperties.class)
public class AggClientAutoConfiguration {

  private final AggClientProperties config;

  private final AggSerializerFactory factory;

  @Bean
  @ConditionalOnClass(CloseableHttpClient.class)
  @ConditionalOnMissingBean(CloseableHttpClient.class)
  public CloseableHttpClient httpClient() {
    return HttpClients.createDefault();
  }

  @Bean
  public AggDigester digester() {
    return new MD5AggDigester(config.getAppKey(), config.getAppSecret());
  }

  @Bean
  @ConditionalOnProperty(prefix = "agg.client", name = "enabled", havingValue = "true")
  public AggClient create(CloseableHttpClient client, AggDigester digester) {
    AggClientConfiguration config = new AggClientConfiguration();
    config.setEndpoint(this.config.getEndpoint());
    config.setAppKey(this.config.getAppKey());
    config.setAppSecret(this.config.getAppSecret());

    return new AggClientImpl(config, factory.create(), client, digester);
  }
}
