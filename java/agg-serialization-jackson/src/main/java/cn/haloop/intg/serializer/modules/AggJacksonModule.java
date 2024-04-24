package cn.haloop.intg.serializer.modules;

import cn.haloop.intg.enums.Gender;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;

/**
 * @author yangtuo
 */
public class AggJacksonModule extends SimpleModule {

  {
    addSerializer(Gender.class, AggGenderSerializer.INSTANCE);
  }

  static class AggGenderSerializer extends StdSerializer<Gender> {

    public static final AggGenderSerializer INSTANCE = new AggGenderSerializer();

    protected AggGenderSerializer() {
      super(Gender.class);
    }

    @Override
    public void serialize(Gender value, JsonGenerator gen, SerializerProvider provider) throws IOException {
      gen.writeNumber(value.getCode());
    }
  }
}
