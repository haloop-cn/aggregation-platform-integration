package cn.haloop.intg.serializer;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;

/**
 * @author yangtuo
 */
@RequiredArgsConstructor
public class AggGsonSerializer implements AggSerializer {

  private final Gson gson;

  @Override
  public String serialize(Object value) {
    return gson.toJson(value);
  }

  @Override
  public <T> T deserialize(String payload, Class<T> clazz) {
    return gson.fromJson(payload, clazz);
  }
}
