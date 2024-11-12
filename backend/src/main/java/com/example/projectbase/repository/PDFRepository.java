package com.example.projectbase.repository;

import com.example.projectbase.domain.entity.PDF;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Pdf repository.
 */
public interface PDFRepository extends JpaRepository<PDF,String> {
}
