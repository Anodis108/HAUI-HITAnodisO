package com.example.projectbase.domain.entity.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

/**
 * The type Flag user date auditing.
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Setter
@Getter
public abstract class FlagUserDateAuditing extends UserDateAuditing {

  @Column(nullable = false)
  private Boolean deleteFlag = Boolean.FALSE;

  @Column(nullable = false)
  private Boolean activeFlag = Boolean.TRUE;

}
