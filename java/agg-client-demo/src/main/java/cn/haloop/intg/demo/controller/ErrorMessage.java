package cn.haloop.intg.demo.controller;

import lombok.Getter;
import lombok.Setter;

/**
 * @author yangtuo
 */
@Getter
@Setter
public class ErrorMessage {

  private String message;

  public ErrorMessage(String message) {
    this.message = message;
  }

}
