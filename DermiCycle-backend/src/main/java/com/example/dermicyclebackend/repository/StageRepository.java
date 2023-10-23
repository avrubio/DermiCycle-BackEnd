package com.example.dermicyclebackend.repository;

import com.example.dermicyclebackend.models.Stage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StageRepository extends JpaRepository<Stage, Long> {
}
