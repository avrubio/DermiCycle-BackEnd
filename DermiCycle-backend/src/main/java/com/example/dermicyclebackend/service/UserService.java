package com.example.dermicyclebackend.service;


import com.example.dermicyclebackend.exception.InformationExistException;
import com.example.dermicyclebackend.models.Product;
import com.example.dermicyclebackend.models.Stage;
import com.example.dermicyclebackend.models.User;
import com.example.dermicyclebackend.repository.ProductRepository;
import com.example.dermicyclebackend.repository.StageRepository;
import com.example.dermicyclebackend.repository.UserRepository;
import com.example.dermicyclebackend.request.LoginRequest;
import com.example.dermicyclebackend.request.ProductWithStage;
import com.example.dermicyclebackend.response.ProductWithStageResponse;
import com.example.dermicyclebackend.security.JwtUtils;
import com.example.dermicyclebackend.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final StageRepository stageRepository;
    private final ProductRepository productRepository;
    private final PasswordEncoder passwordEncoder;

    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public UserService(UserRepository userRepository, ProductRepository productRepository,
                       StageRepository stageRepository, PasswordEncoder passwordEncoder,
                       JwtUtils jwtUtils, @Lazy AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.stageRepository = stageRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
    }

    public User createUser(User userObject) {
        if (!userRepository.existsByEmailAddress(userObject.getEmailAddress())) {
            userObject.setPassword(passwordEncoder.encode(userObject.getPassword()));
            Stage stage1 = new Stage("Stage 1", "Stage 1", "1 day");
            User newUser = userRepository.save(userObject);
            stage1.setUser(newUser);
            stageRepository.save(stage1);
            return newUser;

        } else {
            throw new InformationExistException("user with email address " + userObject.getEmailAddress() + " already exists!");
        }
    }

    public Optional<String> loginUser(LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken authenticationToken = new
                UsernamePasswordAuthenticationToken(loginRequest.getEmailAddress(), loginRequest.getPassword());
        try {
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();
            return Optional.of(jwtUtils.generateJwtToken(myUserDetails));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public User findUserByEmailAddress(String emailAddress) {
        return userRepository.findUserByEmailAddress(emailAddress);
    }

//    public Optional<Product> createProductUser(Product productObject) {
//        Product product = productRepository.findByNameAndUser(productObject.getName(), getCurrentLoggedInUser());
//        if (product != null) {
//            throw new InformationExistException("Product already exists and is a product of User with id " + getCurrentLoggedInUser().getId());
//        } else {
//            productObject.setUser(getCurrentLoggedInUser());
//            return Optional.of(productRepository.save(productObject));
//        }
//    }


    public ProductWithStageResponse createProductUserWithStage(ProductWithStage productWithStageObject) {
        Product product = productRepository.findByNameAndUser(productWithStageObject.getName(), getCurrentLoggedInUser());
        if (product != null) {
            throw new InformationExistException("Product already exists and is a product of User with id " + getCurrentLoggedInUser().getId());
        } else {
            Product newProduct = new Product();
            // handle the error and throw the exception ??
            Stage stage = stageRepository.findById(productWithStageObject.getStageId()).get();
            newProduct.setStage(stage);
            newProduct.setUser(getCurrentLoggedInUser());
            newProduct.setName(productWithStageObject.getName());
            newProduct.setDirections(productWithStageObject.getDirections());
            productRepository.save(newProduct);

            return new ProductWithStageResponse(
                    newProduct.getId(), newProduct.getName(), newProduct.getDirections(), stage.getId(), stage.getName(), stage.getDescription());
        }
    }

    public static User getCurrentLoggedInUser() {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails.getUser();
    }



}

