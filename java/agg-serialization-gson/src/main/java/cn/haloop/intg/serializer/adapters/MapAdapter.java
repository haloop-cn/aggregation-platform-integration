package cn.haloop.intg.serializer.adapters;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Map;

/**
 * @author yangtuo
 */
public class MapAdapter extends TypeAdapter<Map<Object, Object>> {

  private final TypeAdapter<Object> delegateAdapter;

  public MapAdapter(TypeAdapter<Object> delegateAdapter) {
    this.delegateAdapter = delegateAdapter;
  }


  @Override
  public void write(JsonWriter out, Map<Object, Object> value) throws IOException {
    if (value.isEmpty()) {
      out.nullValue();
    } else {
      delegateAdapter.write(out, value);
    }
  }

  @Override
  @SuppressWarnings("unchecked")
  public Map<Object, Object> read(JsonReader in) throws IOException {
    return (Map<Object, Object>) delegateAdapter.read(in);
  }
}