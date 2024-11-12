package com.example.projectbase.domain.mapper;

import com.example.projectbase.domain.dto.request.ProfileCreateDto;
import com.example.projectbase.domain.dto.response.ProfileResponseDto;
import com.example.projectbase.domain.entity.Profile;
import com.example.projectbase.domain.entity.Profile.ProfileBuilder;
import com.example.projectbase.domain.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-12T12:48:41+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.13 (Ubuntu)"
)
@Component
public class ProfileMapperImpl implements ProfileMapper {

    @Override
    public Profile toProfile(ProfileCreateDto profileCreateDto) {
        if ( profileCreateDto == null ) {
            return null;
        }

        ProfileBuilder profile = Profile.builder();

        profile.name( profileCreateDto.getName() );
        profile.phoneNumber( profileCreateDto.getPhoneNumber() );
        profile.email( profileCreateDto.getEmail() );

        return profile.build();
    }

    @Override
    public ProfileResponseDto toProfileResponseDto(Profile profile) {
        if ( profile == null ) {
            return null;
        }

        ProfileResponseDto profileResponseDto = new ProfileResponseDto();

        profileResponseDto.setCreatedBy( profileUserFirstName( profile ) );
        profileResponseDto.setId( profile.getId() );
        profileResponseDto.setName( profile.getName() );
        profileResponseDto.setPhoneNumber( profile.getPhoneNumber() );
        profileResponseDto.setEmail( profile.getEmail() );
        profileResponseDto.setStatus( profile.getStatus() );
        profileResponseDto.setCreatedAt( profile.getCreatedAt() );
        profileResponseDto.setUpdatedAt( profile.getUpdatedAt() );

        return profileResponseDto;
    }

    private String profileUserFirstName(Profile profile) {
        if ( profile == null ) {
            return null;
        }
        User user = profile.getUser();
        if ( user == null ) {
            return null;
        }
        String firstName = user.getFirstName();
        if ( firstName == null ) {
            return null;
        }
        return firstName;
    }
}
