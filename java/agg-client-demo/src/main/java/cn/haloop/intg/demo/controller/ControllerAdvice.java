package cn.haloop.intg.demo.controller;

import cn.haloop.intg.demo.exception.BusinessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author yangtuo
 */
@RestControllerAdvice
public class ControllerAdvice {

  @ExceptionHandler(BusinessException.class)
  public ResponseEntity<ErrorMessage> handle(BusinessException e) {
    return ResponseEntity.badRequest().body(new ErrorMessage(e.getMessage()));
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorMessage> handle(Exception e) {
    return ResponseEntity.internalServerError().body(new ErrorMessage(e.getMessage()));
  }
}
