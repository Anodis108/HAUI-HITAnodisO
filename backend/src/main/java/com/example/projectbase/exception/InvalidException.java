package com.example.projectbase.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * The type Invalid exception.
 */
@Getter
@Setter
public class InvalidException extends RuntimeException {

  private String message;

  private HttpStatus status;

  private String[] params;

  /**
   * Instantiates a new Invalid exception.
   *
   * @param message the message
   */
  public InvalidException(String message) {
    super(message);
    this.status = HttpStatus.BAD_REQUEST;
    this.message = message;
  }

  /**
   * Instantiates a new Invalid exception.
   *
   * @param status  the status
   * @param message the message
   */
  public InvalidException(HttpStatus status, String message) {
    super(message);
    this.status = status;
    this.message = message;
  }

  /**
   * Instantiates a new Invalid exception.
   *
   * @param message the message
   * @param params  the params
   */
  public InvalidException(String message, String[] params) {
    super(message);
    this.status = HttpStatus.BAD_REQUEST;
    this.message = message;
    this.params = params;
  }

  /**
   * Instantiates a new Invalid exception.
   *
   * @param status  the status
   * @param message the message
   * @param params  the params
   */
  public InvalidException(HttpStatus status, String message, String[] params) {
    super(message);
    this.status = status;
    this.message = message;
    this.params = params;
  }

}