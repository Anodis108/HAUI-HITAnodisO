package com.example.projectbase.repository;

import com.example.projectbase.domain.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * The interface Profile repository.
 */
public interface ProfileRepository extends JpaRepository<Profile, String> {
    List<Profile> findProfilesByUserId(String userId);
}
