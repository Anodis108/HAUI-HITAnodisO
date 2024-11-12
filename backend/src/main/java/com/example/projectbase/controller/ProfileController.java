package com.example.projectbase.controller;

import com.example.projectbase.base.RestApiV1;
import com.example.projectbase.base.VsResponseUtil;
import com.example.projectbase.constant.UrlConstant;
import com.example.projectbase.domain.dto.request.ProfileCreateDto;
import com.example.projectbase.domain.dto.request.ProfileUpdateDto;
import com.example.projectbase.service.ProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * The type Profile controller.
 */
@RequiredArgsConstructor
@RestApiV1
public class ProfileController {
    private final ProfileService profileService;

    /**
     * Create profile response entity.
     *
     * @param profileCreateDto the profile create dto
     * @return the response entity
     */
    @Tags({@Tag(name = "profile-controller-admin"), @Tag(name = "profile-controller")})
    @Operation(summary = "API create profile")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @PostMapping(UrlConstant.Profile.CREATE_PROFILE)
    public ResponseEntity<?> createProfile(@RequestBody ProfileCreateDto profileCreateDto) {
        return VsResponseUtil.success(profileService.createProfile(profileCreateDto));
    }

    /**
     * Gets all profiles.
     *
     * @return the all profiles
     */
    @Tag(name = "profile-controller-admin")
    @Operation(summary = "API get all profiles")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping(UrlConstant.Profile.GET_PROFILE)
    public ResponseEntity<?> getAllProfiles() {
        return VsResponseUtil.success(profileService.getAllProfiles());
    }

    /**
     * Gets profiles by user.
     *
     * @param userId the user id
     * @return the profiles by user
     */
    @Tags({@Tag(name = "profile-controller-admin"), @Tag(name = "profile-controller")})
    @Operation(summary = "API get profile by user")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping(UrlConstant.Profile.GET_PROFILE_BY_USERID)
    public ResponseEntity<?> getProfilesByUser(@RequestParam String userId) {
        return VsResponseUtil.success(profileService.getProfilesByUserId(userId));
    }

    /**
     * Update profile response entity.
     *
     * @param profileUpdateDto the profile update dto
     * @return the response entity
     */
    @Tags({@Tag(name = "profile-controller-admin"), @Tag(name = "profile-controller")})
    @Operation(summary = "API update profile")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @PatchMapping(UrlConstant.Profile.UPDATE_PROFILE)
    public ResponseEntity<?> updateProfile(@RequestBody ProfileUpdateDto profileUpdateDto) {
        return VsResponseUtil.success(profileService.updateProfile(profileUpdateDto));
    }

    /**
     * Accept profile response entity.
     *
     * @param profileId the profile id
     * @return the response entity
     */
    @Tag(name = "profile-controller-admin")
    @Operation(summary = "API accept profile")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PatchMapping(UrlConstant.Profile.ACCEPT_PROFILE)
    public ResponseEntity<?> acceptProfile(@RequestParam String profileId) {
        return VsResponseUtil.success(profileService.acceptProfile(profileId));
    }

    /**
     * Reject profile response entity.
     *
     * @param profileId the profile id
     * @return the response entity
     */
    @Tag(name = "profile-controller-admin")
    @Operation(summary = "API reject profile")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PatchMapping(UrlConstant.Profile.REJECT_PROFILE)
    public ResponseEntity<?> rejectProfile(@RequestParam String profileId) {
        return VsResponseUtil.success(profileService.rejectProfile(profileId));
    }

    /**
     * Delete profile response entity.
     *
     * @param profileId the profile id
     * @return the response entity
     */
    @Tags({@Tag(name = "profile-controller-admin"), @Tag(name = "profile-controller")})
    @Operation(summary = "API delete profile")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @DeleteMapping(UrlConstant.Profile.DELETE_PROFILE)
    public ResponseEntity<?> deleteProfile(@RequestParam String profileId) {
        return VsResponseUtil.success(profileService.deleteProfile(profileId));
    }
}
