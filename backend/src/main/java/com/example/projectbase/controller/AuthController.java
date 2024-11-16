package com.example.projectbase.controller;

import com.example.projectbase.base.RestApiV1;
import com.example.projectbase.base.VsResponseUtil;
import com.example.projectbase.constant.UrlConstant;
import com.example.projectbase.domain.dto.request.LoginRequestDto;
import com.example.projectbase.domain.dto.request.UserCreateDto;
import com.example.projectbase.service.AuthService;
import com.example.projectbase.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * The type Auth controller.
 */
@RequiredArgsConstructor
@Validated
@RestApiV1
public class AuthController {

  private final AuthService authService;
  private final UserService userService;

  /**
   * Login response entity.
   *
   * @param request the request
   * @return the response entity
   */
  @Operation(summary = "API Login")
  @PostMapping(UrlConstant.Auth.LOGIN)
  public ResponseEntity<?> login(@Valid @RequestBody LoginRequestDto request) {
    return VsResponseUtil.success(authService.login(request));
  }

  /**
   * Logout response entity.
   *
   * @param request        the request
   * @param response       the response
   * @param authentication the authentication
   * @return the response entity
   */
  @Operation(summary = "API Logout")
  @PostMapping(UrlConstant.Auth.LOGOUT)
  public ResponseEntity<?> logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
    return VsResponseUtil.success(authService.logout(request, response, authentication));
  }

  /**
   * Sign up response entity.
   *
   * @param userCreateDto the user create dto
   * @return the response entity
   */
  @Operation(summary = "API Sign up")
  @PostMapping(UrlConstant.Auth.SIGNUP)
  public ResponseEntity<?> signUp(@RequestBody UserCreateDto userCreateDto) {
    return VsResponseUtil.success(userService.createUser(userCreateDto));
  }

}
