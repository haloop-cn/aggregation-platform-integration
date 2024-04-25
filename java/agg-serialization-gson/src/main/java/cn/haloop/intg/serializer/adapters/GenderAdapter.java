package cn.haloop.intg.serializer.adapters;

import cn.haloop.intg.enums.Gender;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/**
 * @author yangtuo
 */
public class GenderAdapter extends TypeAdapter<Gender> {

  @Override
  public void write(JsonWriter out, Gender value) throws IOException {
    out.value(value.getCode());
  }

  @Override
  public Gender read(JsonReader in) throws IOException {
    return Gender.of(in.nextInt());
  }
}
