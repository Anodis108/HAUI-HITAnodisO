package com.example.projectbase.domain.mapper;

import com.example.projectbase.domain.dto.request.PDFRequestDto;
import com.example.projectbase.domain.dto.response.PDFResponseDto;
import com.example.projectbase.domain.entity.PDF;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * The interface Pdf mapper.
 */
@Mapper(componentModel = "spring")
public interface PDFMapper {
    /**
     * To pdf pdf.
     *
     * @param requestDto the request dto
     * @return the pdf
     */
    PDF toPDF(PDFRequestDto requestDto);

    /**
     * To pdf response dto pdf response dto.
     *
     * @param pdf the pdf
     * @return the pdf response dto
     */
    @Mappings({
            @Mapping(target = "profileName", source = "pdf.profile.name"),
    })
    PDFResponseDto toPDFResponseDto(PDF pdf);
}
