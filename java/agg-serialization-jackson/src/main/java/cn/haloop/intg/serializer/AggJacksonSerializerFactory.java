package cn.haloop.intg.serializer;

import cn.haloop.intg.serializer.modules.AggJacksonModule;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

/**
 * Jackson序列化器工厂
 *
 * @author yangtuo
 */
public class AggJacksonSerializerFactory implements AggSerializerFactory {

  private static final ObjectMapper origin = JsonMapper.builder()
      .build()
      .registerModule(new AggJacksonModule()) // 注册自定义模块
      .configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, true) // 忽略未知属性
      .setSerializationInclusion(JsonInclude.Include.NON_NULL) // 忽略null值
      .setSerializationInclusion(JsonInclude.Include.NON_EMPTY); // 忽略空值

  @Override
  public AggSerializer create() {
    ObjectMapper om = origin.copy();
    return new AggJacksonSerializer(om);
  }
}
