package cn.haloop.intg.serializer.starter;

import cn.haloop.intg.serializer.AggFastJson2SerializerFactory;
import cn.haloop.intg.serializer.AggSerializerFactory;
import com.alibaba.fastjson2.JSON;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yangtuo
 */
@Configuration
@ConditionalOnClass(JSON.class)
@ConditionalOnMissingBean(AggSerializerFactory.class)
public class AggFastjson2SerializerAutoConfiguration {

  @Bean
  public AggSerializerFactory fastJson2() {
    return new AggFastJson2SerializerFactory();
  }
}
