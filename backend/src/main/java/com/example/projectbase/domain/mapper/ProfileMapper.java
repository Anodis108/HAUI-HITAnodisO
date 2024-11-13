package com.example.projectbase.domain.mapper;

import com.example.projectbase.domain.dto.request.ProfileCreateDto;
import com.example.projectbase.domain.dto.response.ProfileResponseDto;
import com.example.projectbase.domain.entity.Profile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * The interface Profile mapper.
 */
@Mapper(componentModel = "spring")
public interface ProfileMapper {

    /**
     * To profile profile.
     *
     * @param profileCreateDto the profile create dto
     * @return the profile
     */
    Profile toProfile(ProfileCreateDto profileCreateDto);

    /**
     * To profile response dto profile response dto.
     *
     * @param profile the profile
     * @return the profile response dto
     */
    @Mappings({
            @Mapping(target = "createdBy", source = "profile.user.username"),
    })
    ProfileResponseDto toProfileResponseDto(Profile profile);
}
