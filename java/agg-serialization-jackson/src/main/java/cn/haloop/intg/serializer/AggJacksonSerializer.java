package cn.haloop.intg.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import lombok.RequiredArgsConstructor;

/**
 * @author yangtuo
 */
@RequiredArgsConstructor
public class AggJacksonSerializer implements AggSerializer {

  private final ObjectMapper om;

  @Override
  public String serialize(Object value) throws IOException {
    return om.writeValueAsString(value);
  }

  @Override
  public <T> T deserialize(String payload, Class<T> clazz) throws IOException {
    return om.readValue(payload, clazz);
  }
}
