package cn.haloop.intg.client;

/**
 * AggClient抽象工厂，用于创建AggClient实例
 *
 * @author yangtuo
 */
public interface AggClientFactory {

  AggClient create(AggClientConfiguration config);
}
