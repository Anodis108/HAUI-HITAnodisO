package com.example.projectbase.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * The type Vs exception.
 */
@Getter
@Setter
public class VsException extends RuntimeException {

  private Object errMessage;

  private HttpStatus status;

  private String[] params;

  /**
   * Instantiates a new Vs exception.
   *
   * @param errMessage the err message
   */
  public VsException(String errMessage) {
    this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    this.errMessage = errMessage;
  }

  /**
   * Instantiates a new Vs exception.
   *
   * @param status     the status
   * @param errMessage the err message
   */
  public VsException(HttpStatus status, Object errMessage) {
    this.errMessage = errMessage;
    this.status = status;
  }

  /**
   * Instantiates a new Vs exception.
   *
   * @param errMessage the err message
   * @param params     the params
   */
  public VsException(String errMessage, String[] params) {
    this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    this.errMessage = errMessage;
    this.params = params;
  }

  /**
   * Instantiates a new Vs exception.
   *
   * @param status     the status
   * @param errMessage the err message
   * @param params     the params
   */
  public VsException(HttpStatus status, String errMessage, String[] params) {
    this.status = status;
    this.errMessage = errMessage;
    this.params = params;
  }

}
