package com.example.projectbase.base;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

/**
 * The type Vs response util.
 */
public class VsResponseUtil {

  /**
   * Success response entity.
   *
   * @param data the data
   * @return the response entity
   */
  public static ResponseEntity<RestData<?>> success(Object data) {
    return success(HttpStatus.OK, data);
  }

  /**
   * Success response entity.
   *
   * @param status the status
   * @param data   the data
   * @return the response entity
   */
  public static ResponseEntity<RestData<?>> success(HttpStatus status, Object data) {
    RestData<?> response = new RestData<>(data);
    return new ResponseEntity<>(response, status);
  }

  /**
   * Success response entity.
   *
   * @param header the header
   * @param data   the data
   * @return the response entity
   */
  public static ResponseEntity<RestData<?>> success(MultiValueMap<String, String> header, Object data) {
    return success(HttpStatus.OK, header, data);
  }

  /**
   * Success response entity.
   *
   * @param status the status
   * @param header the header
   * @param data   the data
   * @return the response entity
   */
  public static ResponseEntity<RestData<?>> success(HttpStatus status, MultiValueMap<String, String> header, Object data) {
    RestData<?> response = new RestData<>(data);
    HttpHeaders responseHeaders = new HttpHeaders();
    responseHeaders.addAll(header);
    return ResponseEntity.ok().headers(responseHeaders).body(response);
  }

  /**
   * Error response entity.
   *
   * @param status  the status
   * @param message the message
   * @return the response entity
   */
  public static ResponseEntity<RestData<?>> error(HttpStatus status, Object message) {
    RestData<?> response = RestData.error(message);
    return new ResponseEntity<>(response, status);
  }

}
