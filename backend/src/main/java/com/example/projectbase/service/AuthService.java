package com.example.projectbase.service;

import com.example.projectbase.domain.dto.request.LoginRequestDto;
import com.example.projectbase.domain.dto.request.TokenRefreshRequestDto;
import com.example.projectbase.domain.dto.response.CommonResponseDto;
import com.example.projectbase.domain.dto.response.LoginResponseDto;
import com.example.projectbase.domain.dto.response.TokenRefreshResponseDto;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The interface Auth service.
 */
public interface AuthService {

  /**
   * Login login response dto.
   *
   * @param request the request
   * @return the login response dto
   */
  LoginResponseDto login(LoginRequestDto request);

  /**
   * Refresh token refresh response dto.
   *
   * @param request the request
   * @return the token refresh response dto
   */
  TokenRefreshResponseDto refresh(TokenRefreshRequestDto request);

  /**
   * Logout common response dto.
   *
   * @param request        the request
   * @param response       the response
   * @param authentication the authentication
   * @return the common response dto
   */
  CommonResponseDto logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication);

}
