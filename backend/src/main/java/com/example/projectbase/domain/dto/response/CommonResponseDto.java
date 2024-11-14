package com.example.projectbase.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Common response dto.
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CommonResponseDto {

  private Boolean status;

  private String message;

}
