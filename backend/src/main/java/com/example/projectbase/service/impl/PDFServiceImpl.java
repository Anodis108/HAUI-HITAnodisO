package com.example.projectbase.service.impl;

import com.example.projectbase.constant.ErrorMessage;
import com.example.projectbase.domain.dto.request.PDFRequestDto;
import com.example.projectbase.domain.dto.response.CommonResponseDto;
import com.example.projectbase.domain.dto.response.PDFResponseDto;
import com.example.projectbase.domain.entity.PDF;
import com.example.projectbase.domain.entity.Profile;
import com.example.projectbase.domain.mapper.PDFMapper;
import com.example.projectbase.exception.NotFoundException;
import com.example.projectbase.repository.PDFRepository;
import com.example.projectbase.repository.ProfileRepository;
import com.example.projectbase.service.PDFService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

/**
 * The type Pdf service.
 */
@Service
@RequiredArgsConstructor
public class PDFServiceImpl implements PDFService {
    private final PDFRepository pdfRepository;
    private final ProfileRepository profileRepository;
    private final PDFMapper pdfMapper;
    private static final String UPLOAD_DIR = "PDFs";


    @Override
    public CommonResponseDto uploadPDF(PDFRequestDto pdfRequestDto) {
        Profile profile = profileRepository.findById(pdfRequestDto.getProfileId())
                .orElseThrow(() -> new NotFoundException(ErrorMessage.Profile.ERR_NOT_FOUND_ID));
        //Create folder PDFs if it not exist
        File directory = new File(UPLOAD_DIR);
        if (!directory.exists()) directory.mkdir();
        //Create folder for user if it is not exist
        File userDir =  new File(UPLOAD_DIR + "/" + profile.getUser().getUsername());
        if (!userDir.exists()) userDir.mkdir();
        //Create folder for profile if it not exist
        File profileDir = new File(UPLOAD_DIR + "/" + profile.getUser().getUsername()+ "/" + profile.getName());
        if (!profileDir.exists()) profileDir.mkdir();

        try {
            String fileName = pdfRequestDto.getFile().getOriginalFilename();
            Path filePath = Paths.get(profileDir.getPath(), fileName);
            Files.write(filePath, pdfRequestDto.getFile().getBytes());
            String fileUrl = "/PDFs/"+profile.getUser().getUsername()+"/"+profile.getName()+"/" + fileName;

            PDF pdf = pdfMapper.toPDF(pdfRequestDto);
            pdf.setCreatedAt(LocalDateTime.now());
            pdf.setProfile(profile);
            pdf.setUrl(fileUrl);
            pdfRepository.save(pdf);
            return new CommonResponseDto(true, "File uploaded successfully, URL: " + fileUrl);
        } catch (IOException e) {
            return new CommonResponseDto(false, "Error saving file: " + e.getMessage());
        }
    }

    @Override
    public List<PDFResponseDto> getPDFsByProfileId(String profileId) {
        List<PDF> pdfs = pdfRepository.findPDFSByProfileId(profileId);
        return  pdfs.stream().map(pdfMapper::toPDFResponseDto).toList();
    }

    @Override
    public CommonResponseDto deletePDF(String pdfId) {
        PDF pdf = pdfRepository.findById(pdfId)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.PDF.ERR_NOT_FOUND_ID));

        try {
            String fileUrl = pdf.getUrl();
            Path filePath = Paths.get(UPLOAD_DIR + fileUrl.replace("/PDFs", ""));

            File file = filePath.toFile();
            if (file.exists() && file.isFile()) {
                if (!file.delete()) {
                    throw new IOException("Failed to delete file: " + filePath);
                }
            }

            pdfRepository.delete(pdf);

            return new CommonResponseDto(true, "PDF deleted successfully");
        } catch (IOException e) {
            return new CommonResponseDto(false, "Error deleting file: " + e.getMessage());
        }
    }


}
