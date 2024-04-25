package cn.haloop.intg.serializer.modules;

import cn.haloop.intg.serializer.AggFastJson2Serializer.Builder;
import cn.haloop.intg.serializer.AggSerializer;
import cn.haloop.intg.serializer.AggSerializerFactory;
import cn.haloop.intg.serializer.filters.IgnoreEmptyPropertyFilter;
import com.alibaba.fastjson2.JSONReader.Feature;

/**
 * @author yangtuo
 */
public class AggFastJson2SerializerFactory implements AggSerializerFactory {

  @Override
  public AggSerializer create() {
    return Builder.builder()
        .registry(AggObjectWriterModule.INSTANCE)
        .addFilters(IgnoreEmptyPropertyFilter.INSTANCE)
        .config(Feature.ErrorOnUnknownProperties).build();
  }
}
