package cn.haloop.intg.serializer;

import cn.haloop.intg.enums.Gender;
import cn.haloop.intg.serializer.AggFastJson2Serializer.Builder;
import com.alibaba.fastjson2.JSONReader.Feature;
import com.alibaba.fastjson2.writer.ObjectWriter;

/**
 * @author yangtuo
 */
public class AggFastJson2SerializerFactory implements AggSerializerFactory {

  @Override
  public AggSerializer create() {
    return Builder.builder()
        .register(Gender.class, (ObjectWriter<Gender>) (jsonWriter, object, fieldName, fieldType, features) -> {
          Gender gender = (Gender) object;
          jsonWriter.writeInt32(gender.getCode());
        })
        .register(Gender.class, (jsonReader, fieldType, fieldName, features) -> Gender.of(jsonReader.readInt32()))
        .addFilters(IgnoreEmptyPropertyFilter.INSTANCE)
        .config(Feature.ErrorOnUnknownProperties).build();
  }
}
