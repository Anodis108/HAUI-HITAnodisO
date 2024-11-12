package com.example.projectbase.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Rest data.
 *
 * @param <T> the type parameter
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestData<T> {

  private RestStatus status;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private T message;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private T data;

  /**
   * Instantiates a new Rest data.
   *
   * @param data the data
   */
  public RestData(T data) {
    this.status = RestStatus.SUCCESS;
    this.data = data;
  }

  /**
   * Error rest data.
   *
   * @param message the message
   * @return the rest data
   */
  public static RestData<?> error(Object message) {
    return new RestData<>(RestStatus.ERROR, message, null);
  }

}
