package com.example.dermicyclebackend.repository;

import com.example.dermicyclebackend.models.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
UserProfile findByUserId(Long userId);
}