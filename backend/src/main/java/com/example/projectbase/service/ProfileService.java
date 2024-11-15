package com.example.projectbase.service;

import com.example.projectbase.domain.dto.request.ProfileCreateDto;
import com.example.projectbase.domain.dto.request.ProfileUpdateDto;
import com.example.projectbase.domain.dto.response.CommonResponseDto;
import com.example.projectbase.domain.dto.response.ProfileResponseDto;

import java.util.List;

/**
 * The interface Profile service.
 */
public interface ProfileService {
    /**
     * Create profile profile response dto.
     *
     * @param profileCreateDto the profile create dto
     * @return the profile response dto
     */
    ProfileResponseDto createProfile(ProfileCreateDto profileCreateDto);

    /**
     * Gets all profiles.
     *
     * @return the all profiles
     */
    List<ProfileResponseDto> getAllProfiles();

    /**
     * Gets profiles by user id.
     *
     * @param userId the user id
     * @return the profiles by user id
     */
    List<ProfileResponseDto> getProfilesByUserId(String userId);

    /**
     * Update profile profile response dto.
     *
     * @param profileUpdateDto the profile update dto
     * @return the profile response dto
     */
    ProfileResponseDto updateProfile(ProfileUpdateDto profileUpdateDto);

    /**
     * Accept profile profile response dto.
     *
     * @param profileId the profile id
     * @return the profile response dto
     */
    ProfileResponseDto acceptProfile(String profileId);

    /**
     * Reject profile profile response dto.
     *
     * @param profileId the profile id
     * @return the profile response dto
     */
    ProfileResponseDto rejectProfile(String profileId);

    /**
     * Delete profile common response dto.
     *
     * @param profileId the profile id
     * @return the common response dto
     */
    CommonResponseDto deleteProfile(String profileId);
}
