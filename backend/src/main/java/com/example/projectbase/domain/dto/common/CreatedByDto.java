package com.example.projectbase.domain.dto.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Created by dto.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreatedByDto {

  private String id;

  private String firstName;

  private String lastName;

  private String avatar;

}
