package com.example.projectbase.domain.dto.pagination;

import com.example.projectbase.constant.CommonConstant;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Pagination search request dto.
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class PaginationSearchRequestDto extends PaginationRequestDto {

  @Parameter(description = "Keyword to search")
  private String keyword = CommonConstant.EMPTY_STRING;

  /**
   * Gets keyword.
   *
   * @return the keyword
   */
  public String getKeyword() {
    return keyword.trim();
  }

}
