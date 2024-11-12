package com.example.projectbase.domain.dto.response;

import com.example.projectbase.constant.CommonConstant;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * The type Login response dto.
 */
@NoArgsConstructor
@Setter
@Getter
public class LoginResponseDto {

  private String tokenType = CommonConstant.BEARER_TOKEN;

  private String accessToken;

  private String refreshToken;

  private String id;

  private Collection<? extends GrantedAuthority> authorities;

  /**
   * Instantiates a new Login response dto.
   *
   * @param accessToken  the access token
   * @param refreshToken the refresh token
   * @param id           the id
   * @param authorities  the authorities
   */
  public LoginResponseDto(String accessToken, String refreshToken, String id, Collection<? extends GrantedAuthority> authorities) {
    this.accessToken = accessToken;
    this.refreshToken = refreshToken;
    this.id = id;
    this.authorities = authorities;
  }

}
