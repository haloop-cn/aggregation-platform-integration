package cn.haloop.intg.serializer.starter;

import cn.haloop.intg.serializer.AggGsonSerializerFactory;
import cn.haloop.intg.serializer.AggSerializerFactory;
import com.google.gson.Gson;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yangtuo
 */
@Configuration
@ConditionalOnClass(Gson.class)
@ConditionalOnMissingBean(AggSerializerFactory.class)
public class AggGsonSerializerAutoConfiguration {

  @Bean
  public AggSerializerFactory gson() {
    return new AggGsonSerializerFactory();
  }
}
