package com.example.projectbase.service;

import com.example.projectbase.domain.dto.request.PDFRequestDto;
import com.example.projectbase.domain.dto.response.CommonResponseDto;
import com.example.projectbase.domain.dto.response.PDFResponseDto;

import java.util.List;

/**
 * The interface Pdf service.
 */
public interface PDFService {


    /**
     * Upload pdf common response dto.
     *
     * @param pdfRequestDto the pdf request dto
     * @return the common response dto
     */
    CommonResponseDto uploadPDF(PDFRequestDto pdfRequestDto);

    /**
     * Gets pd fs by profile id.
     *
     * @param profileId the profile id
     * @return the pd fs by profile id
     */
    List<PDFResponseDto> getPDFsByProfileId(String profileId);

    /**
     * Delete pdf common response dto.
     *
     * @param pdfId the pdf id
     * @return the common response dto
     */
    CommonResponseDto deletePDF(String pdfId);
}
