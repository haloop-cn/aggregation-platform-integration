package cn.haloop.intg.client;

import lombok.Getter;
import lombok.Setter;

/**
 * @author yangtuo
 */
@Getter
@Setter
public abstract class BaseResponse<T> {

  /**
   * 状态码
   */
  private Integer code;

  /**
   * 状态信息
   */
  private String msg;

  /**
   * 数据
   */
  private T data;

  /**
   * 请求处理是否成功
   *
   * @return 是否成功
   */
  public boolean isSuccess() {
    return StatusCode.isSuccess(code);
  }
}
