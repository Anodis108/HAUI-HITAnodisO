package com.example.projectbase.controller;

import com.example.projectbase.base.RestApiV1;
import com.example.projectbase.base.VsResponseUtil;
import com.example.projectbase.constant.UrlConstant;
import com.example.projectbase.domain.dto.request.PDFRequestDto;
import com.example.projectbase.service.PDFService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * The type Pdf controller.
 */
@RequiredArgsConstructor
@RestApiV1
public class PDFController {
    private final PDFService pdfService;


    /**
     * Upload pdf response entity.
     *
     * @param pdfRequestDto the pdf request dto
     * @return the response entity
     */
    @Tags({@Tag(name = "pdf-controller-admin"), @Tag(name = "pdf-controller")})
    @Operation(summary = "API upload pdf in profile")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @PostMapping(value = UrlConstant.PDF.UPLOAD_PDF, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadPDF(@Valid @ModelAttribute PDFRequestDto pdfRequestDto) {
        return VsResponseUtil.success(pdfService.uploadPDF(pdfRequestDto));
    }

    /**
     * Gets pd fby profile id.
     *
     * @param profileId the profile id
     * @return the pd fby profile id
     */
    @Tags({@Tag(name = "pdf-controller-admin"), @Tag(name = "pdf-controller")})
    @Operation(summary = "API get pdf by profile id")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping(value = UrlConstant.PDF.GET_PDF_BY_PROFILE_ID)
    public ResponseEntity<?> getPDFbyProfileId(@RequestParam String profileId) {
        return VsResponseUtil.success(pdfService.getPDFsByProfileId(profileId));
    }


    /**
     * Delete pdf response entity.
     *
     * @param profileId the profile id
     * @return the response entity
     */
    @Tags({@Tag(name = "pdf-controller-admin"), @Tag(name = "pdf-controller")})
    @Operation(summary = "API delete PDF")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @DeleteMapping(value = UrlConstant.PDF.DELETE_PDF)
    public ResponseEntity<?> deletePDF(@RequestParam String profileId) {
        return VsResponseUtil.success(pdfService.deletePDF(profileId));
    }
}
