package com.example.projectbase.controller;

import com.example.projectbase.base.RestApiV1;
import com.example.projectbase.base.VsResponseUtil;
import com.example.projectbase.constant.UrlConstant;
import com.example.projectbase.domain.dto.pagination.PaginationFullRequestDto;
import com.example.projectbase.domain.dto.request.ChangePasswordDto;
import com.example.projectbase.domain.dto.request.UserCreateDto;
import com.example.projectbase.domain.dto.request.UserUpdateDto;
import com.example.projectbase.security.CurrentUser;
import com.example.projectbase.security.UserPrincipal;
import com.example.projectbase.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * The type User controller.
 */
@RequiredArgsConstructor
@RestApiV1
public class UserController {

  private final UserService userService;

  /**
   * Create user response entity.
   *
   * @param userCreateDto the user create dto
   * @return the response entity
   */
  @Tags({@Tag(name = "user-controller-admin"), @Tag(name = "user-controller")})
  @Operation(summary = "API create user")
  @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
  @PostMapping(UrlConstant.User.CREATE_USER)
  public ResponseEntity<?> createUser(@RequestBody UserCreateDto userCreateDto) {
    return VsResponseUtil.success(userService.createUser(userCreateDto));
  }

  /**
   * Change password response entity.
   *
   * @param changePasswordDto the change password dto
   * @return the response entity
   */
  @Tags({@Tag(name = "user-controller-admin"), @Tag(name = "user-controller")})
  @Operation(summary = "API change password")
  @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
  @PatchMapping(UrlConstant.User.CHANGE_PASSWORD)
  public ResponseEntity<?> changePassword(@RequestBody ChangePasswordDto changePasswordDto) {
    return VsResponseUtil.success(userService.changePassword(changePasswordDto));
  }

  /**
   * Update user response entity.
   *
   * @param userUpdateDto the user update dto
   * @return the response entity
   */
  @Tags({@Tag(name = "user-controller-admin"), @Tag(name = "user-controller")})
  @Operation(summary = "API update user")
  @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
  @PatchMapping(UrlConstant.User.UPDATE_USER)
  public ResponseEntity<?> updateUser(@RequestBody UserUpdateDto userUpdateDto) {
    return VsResponseUtil.success(userService.updateUser(userUpdateDto));
  }

  /**
   * Gets user by id.
   *
   * @param userId the user id
   * @return the user by id
   */
  @Tag(name = "user-controller-admin")
  @Operation(summary = "API get user")
  @PreAuthorize("hasRole('ADMIN')")
  @GetMapping(UrlConstant.User.GET_USER)
  public ResponseEntity<?> getUserById(@PathVariable String userId) {
    return VsResponseUtil.success(userService.getUserById(userId));
  }

  /**
   * Gets current user.
   *
   * @param principal the principal
   * @return the current user
   */
  @Tags({@Tag(name = "user-controller-admin"), @Tag(name = "user-controller")})
  @Operation(summary = "API get current user login")
  @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
  @GetMapping(UrlConstant.User.GET_CURRENT_USER)
  public ResponseEntity<?> getCurrentUser(@Parameter(name = "principal", hidden = true)
                                          @CurrentUser UserPrincipal principal) {
    return VsResponseUtil.success(userService.getCurrentUser(principal));
  }

  /**
   * Gets customers.
   *
   * @param requestDTO the request dto
   * @return the customers
   */
  @Tag(name = "user-controller-admin")
  @Operation(summary = "API get all user")
  @PreAuthorize("hasRole('ADMIN')")
  @GetMapping(UrlConstant.User.GET_USERS)
  public ResponseEntity<?> getCustomers(@Valid @ParameterObject PaginationFullRequestDto requestDTO) {
    return VsResponseUtil.success(userService.getUsers(requestDTO));
  }

  /**
   * Delete user by id response entity.
   *
   * @param userId the user id
   * @return the response entity
   */
  @Tag(name = "user-controller-admin")
  @Operation(summary = "API delete user")
  @PreAuthorize("hasRole('ADMIN')")
  @DeleteMapping(UrlConstant.User.DELETE_USER)
  public ResponseEntity<?> DeleteUserById(@RequestParam String userId) {
    return VsResponseUtil.success(userService.deleteUser(userId));
  }

}
