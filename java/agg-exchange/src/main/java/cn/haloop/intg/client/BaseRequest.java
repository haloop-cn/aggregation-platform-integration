package cn.haloop.intg.client;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * @author yangtuo
 */
@Getter
@Setter
public abstract class BaseRequest<T> {

  /**
   * 请求id，用于标识请求
   */
  private final UUID requestId = UUID.randomUUID();

  /**
   * 接口的请求路径，会拼接到服务地址后面。如：/api/v1/xxx
   *
   * @return 请求路径
   */
  public abstract String[] pathSegments();

  /**
   * 请求参数
   */
  private T data;

  public BaseRequest(T data) {
    this.data = data;
  }
}
