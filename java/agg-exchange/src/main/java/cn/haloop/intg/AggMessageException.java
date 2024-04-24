package cn.haloop.intg;

import java.util.UUID;

/**
 * @author yangtuo
 */
public class AggMessageException extends RuntimeException {

  public AggMessageException(String message) {
    super(message);
  }

  public static AggMessageException of(UUID requestId, Integer code, String message) {
    return new AggMessageException(String.format("requestId: %s, code: %s, message: %s", requestId, code, message));
  }
}
