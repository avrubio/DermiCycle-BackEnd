package com.example.dermicyclebackend.repository;

import com.example.dermicyclebackend.models.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing user profiles in the DermiCycle system.
 */
@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

    /**
     * Find a user profile by the ID of the associated user.
     *
     * @param userId The ID of the user associated with the user profile.
     * @return The user profile associated with the specified user ID, if found.
     */
    UserProfile findByUserId(Long userId);
}