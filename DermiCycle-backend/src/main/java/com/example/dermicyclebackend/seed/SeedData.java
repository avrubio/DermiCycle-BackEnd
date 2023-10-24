package com.example.dermicyclebackend.seed;

import com.example.dermicyclebackend.models.User;
import com.example.dermicyclebackend.models.Stage;
import com.example.dermicyclebackend.models.Product;
import com.example.dermicyclebackend.repository.UserRepository;
import com.example.dermicyclebackend.repository.StageRepository;
import com.example.dermicyclebackend.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SeedData implements CommandLineRunner {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final StageRepository stageRepository;
    private final ProductRepository productRepository;

    public SeedData(PasswordEncoder passwordEncoder, UserRepository userRepository, StageRepository stageRepository, ProductRepository productRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.stageRepository = stageRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setEmailAddress("user@example.com");
        user.setPassword(passwordEncoder.encode("password"));
        userRepository.save(user);

        Stage stage1 = new Stage("Stage 1", "Exfoliation", "1 day");
        Stage stage2 = new Stage("Stage 1", "Retnoid", "1 day");
        Stage stage3 = new Stage("Stage 1", "Recovery", "2 days");

        stage1.setUser(user);
        stage2.setUser(user);
        stage3.setUser(user);
        stageRepository.save(stage1);
        stageRepository.save(stage2);
        stageRepository.save(stage3);

        Product product1 = new Product();
        product1.setName("Product 1");
        product1.setDirections("Product 1");
        product1.setStage(stage1);
        product1.setUser(user);
        productRepository.save(product1);

        Product product2 = new Product();
        product2.setName("Product 2");
        product2.setDirections("AProduct 2");
        product2.setStage(stage1);
        product2.setUser(user);
        productRepository.save(product2);

        Product product3 = new Product();
        product3.setName("Product 3");
        product3.setDirections("Product 3");
        product3.setStage(stage1);
        product3.setUser(user);
        productRepository.save(product3);


        Product product4 = new Product();
        product4.setName("Product 4");
        product4.setDirections("Product 4 ");
        product4.setStage(stage2);
        product4.setUser(user);
        productRepository.save(product4);


        Product product5 = new Product();
        product5.setName("Product 5");
        product5.setDirections("Product 5");
        product5.setStage(stage2);
        product5.setUser(user);
        productRepository.save(product5);
    }
}