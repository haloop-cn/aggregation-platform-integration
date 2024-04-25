package cn.haloop.intg.serializer;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONFactory;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.JSONReader.Feature;
import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.JSONWriter.Context;
import com.alibaba.fastjson2.filter.Filter;
import com.alibaba.fastjson2.modules.ObjectReaderModule;
import com.alibaba.fastjson2.modules.ObjectWriterModule;
import com.alibaba.fastjson2.reader.ObjectReaderProvider;
import com.alibaba.fastjson2.writer.ObjectWriterProvider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;

/**
 * @author yangtuo
 */
@RequiredArgsConstructor
public class AggFastJson2Serializer implements AggSerializer {

  private final Builder builder;

  @Override
  public String serialize(Object value) {
    return JSON.toJSONString(value, withWriterContext());
  }

  @Override
  public <T> T deserialize(String payload, Class<T> clazz) {
    return JSON.parseObject(payload, clazz, withReaderContext());
  }

  private JSONReader.Context withReaderContext() {
    JSONReader.Context ctx = JSONFactory.createReadContext(
        builder.readerProvider,
        builder.getReaderFeatures()
    );
    ctx.config(builder.getFilters());
    return ctx;
  }

  private Context withWriterContext() {
    Context ctx = JSONFactory.createWriteContext(
        builder.writerProvider,
        builder.getWriterFeatures()
    );
    ctx.configFilter(builder.getFilters());
    return ctx;
  }


  public static class Builder {

    private final ObjectReaderProvider readerProvider;
    private final ObjectWriterProvider writerProvider;
    private final List<Filter> filters = new ArrayList<>();
    private final List<Feature> readerFeatures = new ArrayList<>();
    private final List<JSONWriter.Feature> writerFeatures = new ArrayList<>();

    private Builder() {
      readerProvider = new ObjectReaderProvider();
      writerProvider = new ObjectWriterProvider();
    }

    public static Builder builder() {
      return new Builder();
    }

    public Builder registry(ObjectWriterModule module) {
      writerProvider.register(module);
      return this;
    }

    public Builder registry(ObjectReaderModule module) {
      readerProvider.register(module);
      return this;
    }

    public Builder config(JSONWriter.Feature... features) {
      writerFeatures.addAll(Arrays.asList(features));
      return this;
    }

    public Builder config(JSONReader.Feature... features) {
      readerFeatures.addAll(Arrays.asList(features));
      return this;
    }

    public Builder addFilters(Filter... filters) {
      this.filters.addAll(Arrays.asList(filters));
      return this;
    }

    private Filter[] getFilters() {
      return filters.toArray(new Filter[0]);
    }

    public AggSerializer build() {
      return new AggFastJson2Serializer(this);
    }

    public JSONWriter.Feature[] getWriterFeatures() {
      return writerFeatures.toArray(new JSONWriter.Feature[0]);
    }

    public JSONReader.Feature[] getReaderFeatures() {
      return readerFeatures.toArray(new JSONReader.Feature[0]);
    }
  }
}
