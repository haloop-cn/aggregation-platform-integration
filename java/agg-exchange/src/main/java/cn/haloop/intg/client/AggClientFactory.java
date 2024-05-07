package cn.haloop.intg.client;

import java.util.ServiceLoader;

/**
 * AggClient抽象工厂，用于创建AggClient实例
 *
 * @author yangtuo
 */
public interface AggClientFactory {

  AggClient create(AggClientConfiguration config);

  /**
   * 支持SPI机制，通过ServiceLoader加载实现类
   *
   * @return AggClientFactory实例
   */
  static AggClientFactory newInstance() {
    ServiceLoader<AggClientFactory> loader = ServiceLoader.load(AggClientFactory.class);
    return loader.iterator().next();
  }
}
