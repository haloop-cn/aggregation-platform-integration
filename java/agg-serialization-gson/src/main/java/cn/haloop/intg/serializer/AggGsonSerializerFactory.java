package cn.haloop.intg.serializer;

import cn.haloop.intg.serializer.adapters.AggAdapterFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author yangtuo
 */
public class AggGsonSerializerFactory implements AggSerializerFactory {

  @Override
  public AggSerializer create() {
    Gson gson = new GsonBuilder()
        .registerTypeAdapterFactory(new AggAdapterFactory())
        .create();
    return new AggGsonSerializer(gson);
  }
}
