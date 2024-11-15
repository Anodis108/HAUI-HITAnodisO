package com.example.projectbase.domain.dto.common;

import lombok.Getter;
import lombok.Setter;

/**
 * The type User date auditing dto.
 */
@Setter
@Getter
public abstract class UserDateAuditingDto extends DateAuditingDto {

  private String createdBy;

  private String lastModifiedBy;

}
