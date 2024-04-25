package cn.haloop.intg.serializer.modules;

import cn.haloop.intg.enums.Gender;
import com.alibaba.fastjson2.modules.ObjectWriterModule;
import com.alibaba.fastjson2.writer.ObjectWriter;
import com.alibaba.fastjson2.writer.ObjectWriters;
import java.lang.reflect.Type;

/**
 * @author yangtuo
 */
public class AggObjectWriterModule implements ObjectWriterModule {

  public static final AggObjectWriterModule INSTANCE = new AggObjectWriterModule();

  @Override
  public ObjectWriter<?> getObjectWriter(Type objectType, Class objectClass) {
    if (objectType == Gender.class) {
      return ObjectWriters.ofToInt(value -> {
        Gender gender = (Gender) value;
        return gender.getCode();
      });
    }
    return null;
  }
}
