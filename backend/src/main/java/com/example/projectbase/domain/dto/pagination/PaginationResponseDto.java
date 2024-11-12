package com.example.projectbase.domain.dto.pagination;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The type Pagination response dto.
 *
 * @param <T> the type parameter
 */
@Setter
@Getter
public class PaginationResponseDto<T> {

  private PagingMeta meta;

  private List<T> items;

  /**
   * Instantiates a new Pagination response dto.
   *
   * @param meta  the meta
   * @param items the items
   */
  public PaginationResponseDto(PagingMeta meta, List<T> items) {
    this.meta = meta;

    if (items == null) {
      this.items = null;
    } else {
      this.items = Collections.unmodifiableList(items);
    }
  }

  /**
   * Gets items.
   *
   * @return the items
   */
  public List<T> getItems() {
    return items == null ? null : new ArrayList<>(items);
  }

}
