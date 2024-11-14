package com.example.projectbase.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * The type Profile response dto.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProfileResponseDto {
    private String id;
    private String name;
    private String phoneNumber;
    private String email;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
}
