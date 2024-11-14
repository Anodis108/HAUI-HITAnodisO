package com.example.projectbase.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * The type Unauthorized exception.
 */
@Getter
@Setter
public class UnauthorizedException extends RuntimeException {

  private String message;

  private HttpStatus status;

  private String[] params;

  /**
   * Instantiates a new Unauthorized exception.
   *
   * @param message the message
   */
  public UnauthorizedException(String message) {
    super(message);
    this.status = HttpStatus.UNAUTHORIZED;
    this.message = message;
  }

  /**
   * Instantiates a new Unauthorized exception.
   *
   * @param status  the status
   * @param message the message
   */
  public UnauthorizedException(HttpStatus status, String message) {
    super(message);
    this.status = status;
    this.message = message;
  }

  /**
   * Instantiates a new Unauthorized exception.
   *
   * @param message the message
   * @param params  the params
   */
  public UnauthorizedException(String message, String[] params) {
    super(message);
    this.status = HttpStatus.UNAUTHORIZED;
    this.message = message;
    this.params = params;
  }

  /**
   * Instantiates a new Unauthorized exception.
   *
   * @param status  the status
   * @param message the message
   * @param params  the params
   */
  public UnauthorizedException(HttpStatus status, String message, String[] params) {
    super(message);
    this.status = status;
    this.message = message;
    this.params = params;
  }

}