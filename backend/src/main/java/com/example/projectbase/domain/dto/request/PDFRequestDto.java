package com.example.projectbase.domain.dto.request;

import com.example.projectbase.aop.annotation.ValidFile;
import com.example.projectbase.constant.ErrorMessage;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

/**
 * The type Pdf request dto.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PDFRequestDto {

    @NotNull(message = ErrorMessage.INVALID_SOME_THING_FIELD_IS_REQUIRED)
    private String name;

    @NotNull(message = ErrorMessage.INVALID_SOME_THING_FIELD_IS_REQUIRED)
    private String profileId;

    @ValidFile
    private MultipartFile file;

}
