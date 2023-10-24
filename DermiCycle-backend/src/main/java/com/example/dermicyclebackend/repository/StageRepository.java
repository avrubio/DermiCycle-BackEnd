package com.example.dermicyclebackend.repository;

import com.example.dermicyclebackend.models.Product;
import com.example.dermicyclebackend.models.Stage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing stages in the DermiCycle system.
 */
@Repository
public interface StageRepository extends JpaRepository<Stage, Long> {

    /**
     * Find a stage by the ID of the associated product.
     *
     * @param productId The ID of the product associated with the stage.
     * @return The stage associated with the specified product ID, if found.
     */
    Product findByProductId(Long productId);
}