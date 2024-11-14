package com.example.projectbase.service.impl;

import com.example.projectbase.constant.ErrorMessage;
import com.example.projectbase.constant.ProfileConstant;
import com.example.projectbase.constant.ResponeConstant;
import com.example.projectbase.domain.dto.request.ProfileCreateDto;
import com.example.projectbase.domain.dto.request.ProfileUpdateDto;
import com.example.projectbase.domain.dto.response.CommonResponseDto;
import com.example.projectbase.domain.dto.response.ProfileResponseDto;
import com.example.projectbase.domain.entity.PDF;
import com.example.projectbase.domain.entity.Profile;
import com.example.projectbase.domain.entity.User;
import com.example.projectbase.domain.mapper.ProfileMapper;
import com.example.projectbase.exception.NotFoundException;
import com.example.projectbase.exception.ProfileAlreadyAccepted;
import com.example.projectbase.exception.UserAlreadyHasThisProfile;
import com.example.projectbase.repository.PDFRepository;
import com.example.projectbase.repository.ProfileRepository;
import com.example.projectbase.repository.UserRepository;
import com.example.projectbase.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    private final PDFRepository pdfRepository;
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
        if(profile.getStatus().equals( ProfileConstant.ACCEPT)) throw new ProfileAlreadyAccepted("Profile "+ profile.getName()+" is already accepted");
        profile.setStatus(ProfileConstant.ACCEPT);
        WebClient webClient = WebClient.builder()
                .baseUrl("https://fastapi-example-5q70.onrender.com")
                .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(10 * 1024 * 1024))
                .build();
        List<PDF> pdfs = pdfRepository.findPDFSByProfileId(profileId);
        if(!pdfs.isEmpty())
            for(PDF pdf : pdfs) {
                try {
                    stampPDF(pdf, webClient);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
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

    private void stampPDF(PDF pdf, WebClient webClient) throws IOException {
        FileSystemResource pdfFile = new FileSystemResource("PDFs"+pdf.getUrl().replace("/PDFs", ""));
        FileSystemResource stampImage = new FileSystemResource("stamp.png");
        byte[] responseBytes = webClient.post()
                .uri(uriBuilder -> uriBuilder
                        .path("/stamp-pdf/")
                        .queryParam("page_number", 1)
                        .build())
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromMultipartData("pdf_file", pdfFile)
                        .with("stamp_image", stampImage))
                .retrieve()
                .bodyToMono(byte[].class)
                .block();
        String outputFilePath = "PDFs/" + pdf.getProfile().getUser().getUsername()+ "/" + pdf.getProfile().getName()+"/stamped_"+pdf.getName()+".pdf";
        if (responseBytes != null) {
            try (FileOutputStream outputStream = new FileOutputStream(outputFilePath)) {
                outputStream.write(responseBytes);
                String fileUrl = pdf.getUrl();
                Path filePath = Paths.get("PDFs" + fileUrl.replace("/PDFs", ""));
                File file = filePath.toFile();
                if (file.exists() && file.isFile()) {
                    if (!file.delete()) {
                        throw new IOException("Failed to delete file: " + filePath);
                    }
                }
                pdf.setUrl(outputFilePath);
                pdfRepository.save(pdf);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            System.out.println("File saved to: " + outputFilePath);
        } else {
            System.err.println("Failed to get response from API");
        }
    }
}
