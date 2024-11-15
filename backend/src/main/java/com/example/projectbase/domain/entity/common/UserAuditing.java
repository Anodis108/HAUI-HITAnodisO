package com.example.projectbase.domain.entity.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

/**
 * The type User auditing.
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Setter
@Getter
public abstract class UserAuditing {

  @CreatedBy
  @Column(updatable = false)
  private String createdBy;

  @LastModifiedBy
  @Column(nullable = false)
  private String lastModifiedBy;

}
