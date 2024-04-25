package cn.haloop.intg.serializer.starter;

import cn.haloop.intg.serializer.AggGsonSerializerFactory;
import cn.haloop.intg.serializer.AggJacksonSerializerFactory;
import cn.haloop.intg.serializer.AggSerializerFactory;
import cn.haloop.intg.serializer.modules.AggFastJson2SerializerFactory;
import com.alibaba.fastjson2.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yangtuo
 */
@Configuration
public class AggSerializerFactoryAutoConfiguration {

  @Bean
  @ConditionalOnClass(ObjectMapper.class)
  @ConditionalOnMissingBean(AggSerializerFactory.class)
  public AggSerializerFactory jackson() {
    return new AggJacksonSerializerFactory();
  }


  @Bean
  @ConditionalOnClass(JSON.class)
  @ConditionalOnMissingBean(AggSerializerFactory.class)
  public AggSerializerFactory fastJson() {
    return new AggFastJson2SerializerFactory();
  }

  @Bean
  @ConditionalOnClass(Gson.class)
  @ConditionalOnMissingBean(AggSerializerFactory.class)
  public AggSerializerFactory gson() {
    return new AggGsonSerializerFactory();
  }

}
