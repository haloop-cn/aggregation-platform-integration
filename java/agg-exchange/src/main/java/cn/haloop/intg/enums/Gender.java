package cn.haloop.intg.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 性别
 *
 * @author yangtuo
 */
@Getter
@RequiredArgsConstructor
public enum Gender {

  /**
   * 未知
   */
  UNKNOWN(0, "未知"),

  /**
   * 男
   */
  MALE(1, "男"),

  /**
   * 女
   */
  FEMALE(2, "女");

  private final int code;
  private final String value;

  public static Gender of(Integer gender) {
    switch (gender) {
      case 1:
        return MALE;
      case 2:
        return FEMALE;
      default:
        return UNKNOWN;
    }
  }


  @Override
  public String toString() {
    return value;
  }
}
