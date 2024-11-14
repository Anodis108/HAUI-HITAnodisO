package com.example.projectbase.repository;

import com.example.projectbase.domain.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * The interface Profile repository.
 */
public interface ProfileRepository extends JpaRepository<Profile, String> {
    /**
     * Find profiles by user id list.
     *
     * @param userId the user id
     * @return the list
     */
    List<Profile> findProfilesByUserId(String userId);

    /**
     * Find profiles by name and user id optional.
     *
     * @param name   the name
     * @param userId the user id
     * @return the optional
     */
    Optional<Profile> findProfilesByNameAndUserId(String name, String userId);
}
