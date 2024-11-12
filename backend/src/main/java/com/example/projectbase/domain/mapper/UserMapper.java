package com.example.projectbase.domain.mapper;

import com.example.projectbase.domain.dto.request.UserCreateDto;
import com.example.projectbase.domain.dto.response.UserDto;
import com.example.projectbase.domain.entity.User;
import org.mapstruct.*;

import java.util.List;

/**
 * The interface User mapper.
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

  /**
   * To user user.
   *
   * @param userCreateDTO the user create dto
   * @return the user
   */
  User toUser(UserCreateDto userCreateDTO);

  /**
   * To user dto user dto.
   *
   * @param user the user
   * @return the user dto
   */
  @Mappings({
      @Mapping(target = "roleName", source = "user.role.name"),
  })
  UserDto toUserDto(User user);

  /**
   * To user dtos list.
   *
   * @param user the user
   * @return the list
   */
  List<UserDto> toUserDtos(List<User> user);

}
