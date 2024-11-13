package com.example.projectbase.domain.mapper;

import com.example.projectbase.domain.dto.request.PDFRequestDto;
import com.example.projectbase.domain.dto.response.PDFResponseDto;
import com.example.projectbase.domain.entity.PDF;
import com.example.projectbase.domain.entity.PDF.PDFBuilder;
import com.example.projectbase.domain.entity.Profile;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-13T21:15:44+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.13 (Ubuntu)"
)
@Component
public class PDFMapperImpl implements PDFMapper {

    @Override
    public PDF toPDF(PDFRequestDto requestDto) {
        if ( requestDto == null ) {
            return null;
        }

        PDFBuilder pDF = PDF.builder();

        pDF.name( requestDto.getName() );

        return pDF.build();
    }

    @Override
    public PDFResponseDto toPDFResponseDto(PDF pdf) {
        if ( pdf == null ) {
            return null;
        }

        PDFResponseDto pDFResponseDto = new PDFResponseDto();

        pDFResponseDto.setProfileName( pdfProfileName( pdf ) );
        pDFResponseDto.setId( pdf.getId() );
        pDFResponseDto.setName( pdf.getName() );
        pDFResponseDto.setUrl( pdf.getUrl() );
        pDFResponseDto.setCreatedAt( pdf.getCreatedAt() );

        return pDFResponseDto;
    }

    private String pdfProfileName(PDF pDF) {
        if ( pDF == null ) {
            return null;
        }
        Profile profile = pDF.getProfile();
        if ( profile == null ) {
            return null;
        }
        String name = profile.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
