package com.example.projectbase.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * The type Forbidden exception.
 */
@Getter
@Setter
public class ForbiddenException extends RuntimeException {

  private String message;

  private HttpStatus status;

  private String[] params;

  /**
   * Instantiates a new Forbidden exception.
   *
   * @param message the message
   */
  public ForbiddenException(String message) {
    super(message);
    this.status = HttpStatus.FORBIDDEN;
    this.message = message;
  }

  /**
   * Instantiates a new Forbidden exception.
   *
   * @param status  the status
   * @param message the message
   */
  public ForbiddenException(HttpStatus status, String message) {
    super(message);
    this.status = status;
    this.message = message;
  }

  /**
   * Instantiates a new Forbidden exception.
   *
   * @param message the message
   * @param params  the params
   */
  public ForbiddenException(String message, String[] params) {
    super(message);
    this.status = HttpStatus.FORBIDDEN;
    this.message = message;
    this.params = params;
  }

  /**
   * Instantiates a new Forbidden exception.
   *
   * @param status  the status
   * @param message the message
   * @param params  the params
   */
  public ForbiddenException(HttpStatus status, String message, String[] params) {
    super(message);
    this.status = status;
    this.message = message;
    this.params = params;
  }

}