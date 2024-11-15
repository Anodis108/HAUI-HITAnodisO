package com.example.projectbase.domain.dto.pagination;

import com.example.projectbase.constant.CommonConstant;
import com.example.projectbase.constant.SortByDataConstant;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Pagination sort request dto.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaginationSortRequestDto extends PaginationRequestDto {

  @Parameter(description = "The name of property want to sort")
  private String sortBy = CommonConstant.EMPTY_STRING;

  @Parameter(description = "Sorting criteria - Default sort order is descending")
  private Boolean isAscending = Boolean.FALSE;

    /**
     * Gets sort by.
     *
     * @param constant the constant
     * @return the sort by
     */
    public String getSortBy(SortByDataConstant constant) {
    return constant.getSortBy(sortBy);
  }

}
