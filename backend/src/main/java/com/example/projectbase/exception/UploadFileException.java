package com.example.projectbase.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * The type Upload file exception.
 */
@Getter
@Setter
public class UploadFileException extends RuntimeException {

  private String message;

  private HttpStatus status;

  private String[] params;

  /**
   * Instantiates a new Upload file exception.
   *
   * @param message the message
   */
  public UploadFileException(String message) {
    super(message);
    this.status = HttpStatus.BAD_GATEWAY;
    this.message = message;
  }

  /**
   * Instantiates a new Upload file exception.
   *
   * @param status  the status
   * @param message the message
   */
  public UploadFileException(HttpStatus status, String message) {
    super(message);
    this.status = status;
    this.message = message;
  }

  /**
   * Instantiates a new Upload file exception.
   *
   * @param message the message
   * @param params  the params
   */
  public UploadFileException(String message, String[] params) {
    super(message);
    this.status = HttpStatus.BAD_GATEWAY;
    this.message = message;
    this.params = params;
  }

  /**
   * Instantiates a new Upload file exception.
   *
   * @param status  the status
   * @param message the message
   * @param params  the params
   */
  public UploadFileException(HttpStatus status, String message, String[] params) {
    super(message);
    this.status = status;
    this.message = message;
    this.params = params;
  }

}
