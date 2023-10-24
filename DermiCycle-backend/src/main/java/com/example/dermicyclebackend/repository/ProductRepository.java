package com.example.dermicyclebackend.repository;

import com.example.dermicyclebackend.models.Product;
import com.example.dermicyclebackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing products in the DermiCycle system.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    /**
     * Find a product by its name and the associated user.
     *
     * @param productName The name of the product to search for.
     * @param user       The user associated with the product.
     * @return The product with the specified name and user, if found.
     */
    Product findByNameAndUser(String productName, User user);

    /**
     * Find a product by its user's ID.
     *
     * @param userId The ID of the user associated with the product.
     * @return The product associated with the specified user ID, if found.
     */
    Product findByUserId(Long userId);

    /**
     * Find a list of products by their stage ID and the associated user.
     *
     * @param stageId The ID of the stage to which products belong.
     * @param user    The user associated with the products.
     * @return A list of products associated with the specified stage and user.
     */
    List<Product> findByStageIdAndUser(Long stageId, User user);
}