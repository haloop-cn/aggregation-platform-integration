package cn.haloop.intg.serializer;

import com.alibaba.fastjson2.JSON;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author yangtuo
 */
public class SerializationTest {

  private final AggSerializer serializer = new AggFastJson2SerializerFactory().create();

  @Test
  void testFieldSerializationOrder() throws IOException {
    Map<String, Object> source = new HashMap<>();
    source.put("b", "b");
    source.put("a", "a");

    String json = serializer.serialize(source);
    Assertions.assertEquals("{\"a\":\"a\",\"b\":\"b\"}", json);

    Map<String, Object> nested = new HashMap<>();
    nested.put("c", source);
    nested.put("d", source);
    String nestedJson = serializer.serialize(nested);
    Assertions.assertEquals("{\"c\":{\"a\":\"a\",\"b\":\"b\"},\"d\":{\"a\":\"a\",\"b\":\"b\"}}", nestedJson);
  }

  @Test
  void testEmptyElimination() throws IOException {
    Map<String, Object> source = new HashMap<>();
    source.put("nullValue", null);
    source.put("emptyValue", "");
    source.put("emptyArray", new String[0]);
    source.put("emptyMap", new HashMap<>());
    source.put("zero", 0);

    String originValue = JSON.toJSONString(source);
    Assertions.assertEquals(
        "{\"zero\":0,\"emptyValue\":\"\",\"emptyMap\":{},\"emptyArray\":[]}",
        originValue);

    String json = serializer.serialize(source);
    Assertions.assertEquals("{\"zero\":0}", json);
  }
}
