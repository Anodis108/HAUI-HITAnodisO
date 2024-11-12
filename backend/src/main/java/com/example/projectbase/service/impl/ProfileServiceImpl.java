package com.example.projectbase.service.impl;

import com.example.projectbase.constant.ErrorMessage;
import com.example.projectbase.constant.ProfileConstant;
import com.example.projectbase.constant.ResponeConstant;
import com.example.projectbase.domain.dto.request.ProfileCreateDto;
import com.example.projectbase.domain.dto.request.ProfileUpdateDto;
import com.example.projectbase.domain.dto.response.CommonResponseDto;
import com.example.projectbase.domain.dto.response.ProfileResponseDto;
import com.example.projectbase.domain.entity.Profile;
import com.example.projectbase.domain.entity.User;
import com.example.projectbase.domain.mapper.ProfileMapper;
import com.example.projectbase.exception.NotFoundException;
import com.example.projectbase.exception.UserAlreadyHasThisProfile;
import com.example.projectbase.repository.ProfileRepository;
import com.example.projectbase.repository.UserRepository;
import com.example.projectbase.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * The type Profile service.
 */
@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;
    private final ProfileMapper profileMapper;

    @Override
    public ProfileResponseDto createProfile(ProfileCreateDto profileCreateDto) {
        User user =  userRepository.findById(profileCreateDto.getUserId()).orElseThrow(() -> new NotFoundException(ErrorMessage.User.ERR_NOT_FOUND_ID));
        boolean profileExists = profileRepository.findProfilesByNameAndUserId(profileCreateDto.getName(), user.getId()).isPresent();
        if(profileExists) {
            throw new UserAlreadyHasThisProfile("You already have this profile: "+profileCreateDto.getName());
        }
        Profile profile = profileMapper.toProfile(profileCreateDto);
        profile.setUser(user);
        profile.setStatus(ProfileConstant.PENDING);
        profile.setCreatedAt(LocalDateTime.now());
        profile.setUpdatedAt(LocalDateTime.now());
        return profileMapper.toProfileResponseDto(profileRepository.save(profile));
    }

    @Override
    public List<ProfileResponseDto> getAllProfiles() {
        List<Profile> profiles = profileRepository.findAll();
        return profiles.stream().map(profileMapper::toProfileResponseDto).toList();
    }

    @Override
    public List<ProfileResponseDto> getProfilesByUserId(String userId) {
        List<Profile> profiles = profileRepository.findProfilesByUserId(userId);
        return profiles.stream().map(profileMapper::toProfileResponseDto).toList();
    }

    @Override
    public ProfileResponseDto updateProfile(ProfileUpdateDto profileUpdateDto) {
        Profile profile = profileRepository.findById(profileUpdateDto.getProfileId()).orElseThrow(() -> new NotFoundException(ErrorMessage.Profile.ERR_NOT_FOUND_ID));
        profile.setUpdatedAt(LocalDateTime.now());
        profile.setName(profileUpdateDto.getName());
        profile.setEmail(profileUpdateDto.getEmail());
        profile.setPhoneNumber(profileUpdateDto.getPhoneNumber());
        profile.setStatus(ProfileConstant.PENDING);
        return profileMapper.toProfileResponseDto(profileRepository.save(profile));
    }

    @Override
    public ProfileResponseDto acceptProfile(String profileId) {
        Profile profile = profileRepository.findById(profileId).orElseThrow(() -> new NotFoundException(ErrorMessage.Profile.ERR_NOT_FOUND_ID));
        profile.setStatus(ProfileConstant.ACCEPT);
        return profileMapper.toProfileResponseDto(profileRepository.save(profile));
    }

    @Override
    public ProfileResponseDto rejectProfile(String profileId) {
        Profile profile = profileRepository.findById(profileId).orElseThrow(() -> new NotFoundException(ErrorMessage.Profile.ERR_NOT_FOUND_ID));
        profile.setStatus(ProfileConstant.REJECT);
        return profileMapper.toProfileResponseDto(profileRepository.save(profile));
    }


    @Override
    public CommonResponseDto deleteProfile(String profileId) {
        Profile profile = profileRepository.findById(profileId).orElseThrow(() -> new NotFoundException(ErrorMessage.Profile.ERR_NOT_FOUND_ID));
        profileRepository.delete(profile);
        return new CommonResponseDto(true, ResponeConstant.SUCCESS);
    }
}
