package cn.haloop.intg.demo.exception;

/**
 * @author yangtuo
 */
public class BusinessException extends RuntimeException {

  public BusinessException(String message) {
    super(message);
  }
}
