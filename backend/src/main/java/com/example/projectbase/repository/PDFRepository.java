package com.example.projectbase.repository;

import com.example.projectbase.domain.entity.PDF;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * The interface Pdf repository.
 */
public interface PDFRepository extends JpaRepository<PDF,String> {
    /**
     * Find pdfs by profile id list.
     *
     * @param profileId the profile id
     * @return the list
     */
    List<PDF> findPDFSByProfileId(String profileId);
}
