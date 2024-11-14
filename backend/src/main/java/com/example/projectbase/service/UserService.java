package com.example.projectbase.service;

import com.example.projectbase.domain.dto.pagination.PaginationFullRequestDto;
import com.example.projectbase.domain.dto.pagination.PaginationResponseDto;
import com.example.projectbase.domain.dto.request.ChangePasswordDto;
import com.example.projectbase.domain.dto.request.UserCreateDto;
import com.example.projectbase.domain.dto.request.UserUpdateDto;
import com.example.projectbase.domain.dto.response.CommonResponseDto;
import com.example.projectbase.domain.dto.response.UserDto;
import com.example.projectbase.security.UserPrincipal;

/**
 * The interface User service.
 */
public interface UserService {

    /**
     * Create user user dto.
     *
     * @param userCreateDto the user create dto
     * @return the user dto
     */
    UserDto createUser(UserCreateDto userCreateDto);

    /**
     * Gets user by id.
     *
     * @param userId the user id
     * @return the user by id
     */
    UserDto getUserById(String userId);

    /**
     * Gets users.
     *
     * @param request the request
     * @return the users
     */
    PaginationResponseDto<UserDto> getUsers(PaginationFullRequestDto request);

    /**
     * Gets current user.
     *
     * @param principal the principal
     * @return the current user
     */
    UserDto getCurrentUser(UserPrincipal principal);

    /**
     * Change password common response dto.
     *
     * @param changePasswordDto the change password dto
     * @return the common response dto
     */
    CommonResponseDto changePassword(ChangePasswordDto changePasswordDto);

    /**
     * Update user user dto.
     *
     * @param userUpdateDto the user update dto
     * @return the user dto
     */
    UserDto updateUser(UserUpdateDto userUpdateDto);

    /**
     * Delete user common response dto.
     *
     * @param userId the user id
     * @return the common response dto
     */
    CommonResponseDto deleteUser(String userId);

}
