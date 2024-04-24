package cn.haloop.intg.serializer;

import java.util.ServiceLoader;

/**
 * @author yangtuo
 */
public interface AggSerializerFactory {

  AggSerializer create();

  static AggSerializerFactory newInstance() {
    ServiceLoader<AggSerializerFactory> loader = ServiceLoader.load(AggSerializerFactory.class);
    return loader.iterator().next();
  }

}
