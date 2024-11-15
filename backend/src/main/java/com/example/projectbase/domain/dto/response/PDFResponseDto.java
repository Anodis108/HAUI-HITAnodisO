package com.example.projectbase.domain.dto.response;

import lombok.*;

import java.time.LocalDateTime;

/**
 * The type Pdf response dto.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PDFResponseDto {
    private String id;
    private String name;
    private String url;
    private LocalDateTime createdAt;
    private String profileName;
}
