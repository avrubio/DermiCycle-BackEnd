package com.example.dermicyclebackend.repository;

import com.example.dermicyclebackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Repository interface for managing Doctor entities using Spring Data JPA.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Find a user by their email address.
     *
     * @param emailAddress The email address of the user to find.
     * @return The user with the specified email address or null if not found.
     */
    User findUserByEmailAddress(String emailAddress);
    /**
     * Check if a user with a given email address exists.
     *
     * @param emailAddress The email address to check for existence.
     * @return True if a user with the email address exists, false otherwise.
     */
    boolean existsByEmailAddress(String emailAddress);
}
