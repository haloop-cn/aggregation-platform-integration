package cn.haloop.intg.client;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author yangtuo
 */
@Getter
@RequiredArgsConstructor
public enum StatusCode {

  SUCCESS(0, "成功"),
  PARAM_ERROR(10102, "参数错误"),
  SERVER_ERROR(10103, "服务端错误"),
  INVALID_SIGN(10104, "签名错误"),
  REQUEST_EXPIRED(10105, "请求过期"),
  ;

  private final int code;
  private final String msg;

  public static boolean isSuccess(Integer code) {
    if (code == null) {
      return false;
    }
    return SUCCESS.code == code;
  }
}
