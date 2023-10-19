package com.example.dermicyclebackend.repository;

import com.example.dermicyclebackend.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByUserIdAndEmailAddress(Long userId, String emailAddress, String directions);

    Product findByUserId(Long userId);
}
