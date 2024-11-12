package com.example.projectbase.domain.dto.response;

import com.example.projectbase.constant.CommonConstant;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Token refresh response dto.
 */
@NoArgsConstructor
@Setter
@Getter
public class TokenRefreshResponseDto {

  private String tokenType = CommonConstant.BEARER_TOKEN;

  private String accessToken;

  private String refreshToken;

  /**
   * Instantiates a new Token refresh response dto.
   *
   * @param accessToken  the access token
   * @param refreshToken the refresh token
   */
  public TokenRefreshResponseDto(String accessToken, String refreshToken) {
    this.accessToken = accessToken;
    this.refreshToken = refreshToken;
  }

}
