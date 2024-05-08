package cn.haloop.intg.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import cn.haloop.intg.serializer.AggSerializerFactory;
import org.junit.jupiter.api.Test;

/**
 * @author yangtuo
 */
class SpiTest {

  @Test
  void loadSerializer() {
    AggSerializerFactory factory = AggSerializerFactory.newInstance();
    assertNotNull(factory);
  }
}
