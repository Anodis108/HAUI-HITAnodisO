package com.example.projectbase.domain.dto.pagination;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Paging meta.
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PagingMeta {

  private Long totalElements;

  private Integer totalPages;

  private Integer pageNum;

  private Integer pageSize;

  private String sortBy;

  private String sortType;

}