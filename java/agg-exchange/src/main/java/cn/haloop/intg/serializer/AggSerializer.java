package cn.haloop.intg.serializer;

import java.io.IOException;

/**
 * 序列化器
 *
 * @author yangtuo
 */
public interface AggSerializer {

  /**
   * 序列化
   *
   * @param value 待序列化对象
   * @return 序列化后的字符串
   * @throws IOException 序列化异常
   */
  String serialize(Object value) throws IOException;

  /**
   * 反序列化
   */
  <T> T deserialize(String payload, Class<T> clazz) throws IOException;
}
