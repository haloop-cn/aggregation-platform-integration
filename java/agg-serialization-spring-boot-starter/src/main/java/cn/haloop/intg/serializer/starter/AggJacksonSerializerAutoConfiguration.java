package cn.haloop.intg.serializer.starter;

import cn.haloop.intg.serializer.AggJacksonSerializerFactory;
import cn.haloop.intg.serializer.AggSerializerFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yangtuo
 */
@Configuration
@ConditionalOnClass(ObjectMapper.class)
@ConditionalOnMissingBean(AggSerializerFactory.class)
public class AggJacksonSerializerAutoConfiguration {

  @Bean(name = "aggJacksonSerializerFactory")
  public AggSerializerFactory jackson() {
    return new AggJacksonSerializerFactory();
  }
}
