package com.example.projectbase.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * The type Not found exception.
 */
@Getter
@Setter
public class NotFoundException extends RuntimeException {

  private String message;

  private HttpStatus status;

  private String[] params;

  /**
   * Instantiates a new Not found exception.
   *
   * @param message the message
   */
  public NotFoundException(String message) {
    super(message);
    this.status = HttpStatus.NOT_FOUND;
    this.message = message;
  }

  /**
   * Instantiates a new Not found exception.
   *
   * @param status  the status
   * @param message the message
   */
  public NotFoundException(HttpStatus status, String message) {
    super(message);
    this.status = status;
    this.message = message;
  }

  /**
   * Instantiates a new Not found exception.
   *
   * @param message the message
   * @param params  the params
   */
  public NotFoundException(String message, String[] params) {
    super(message);
    this.status = HttpStatus.NOT_FOUND;
    this.message = message;
    this.params = params;
  }

  /**
   * Instantiates a new Not found exception.
   *
   * @param status  the status
   * @param message the message
   * @param params  the params
   */
  public NotFoundException(HttpStatus status, String message, String[] params) {
    super(message);
    this.status = status;
    this.message = message;
    this.params = params;
  }

}