package com.example.dermicyclebackend.repository;

import com.example.dermicyclebackend.models.Product;
import com.example.dermicyclebackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByNameAndUser(String productName, User user);

    Product findByUserId(Long userId);
}
