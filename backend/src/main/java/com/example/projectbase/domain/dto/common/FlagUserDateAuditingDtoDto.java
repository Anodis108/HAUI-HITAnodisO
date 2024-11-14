package com.example.projectbase.domain.dto.common;

import lombok.Getter;
import lombok.Setter;

/**
 * The type Flag user date auditing dto dto.
 */
@Setter
@Getter
public abstract class FlagUserDateAuditingDtoDto extends UserDateAuditingDto {

  private Boolean deleteFlag;

  private Boolean activeFlag;

}
