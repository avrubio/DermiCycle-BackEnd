package com.example.dermicyclebackend.service;


import com.example.dermicyclebackend.exception.InformationExistException;
import com.example.dermicyclebackend.models.Product;
import com.example.dermicyclebackend.models.User;
import com.example.dermicyclebackend.repository.ProductRepository;
import com.example.dermicyclebackend.repository.UserRepository;
import com.example.dermicyclebackend.request.LoginRequest;
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
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final PasswordEncoder passwordEncoder;

    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public UserService(UserRepository userRepository, ProductRepository productRepository, PasswordEncoder passwordEncoder,
                       JwtUtils jwtUtils, @Lazy AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
    }

    public User createUser(User userObject) {
        if (!userRepository.existsByEmailAddress(userObject.getEmailAddress())) {
            userObject.setPassword(passwordEncoder.encode(userObject.getPassword()));
            return userRepository.save(userObject);

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

    public Optional<Product> createProductUser(@RequestBody  Product productObject) {
        Product product = productRepository.findByNameAndUser(productObject.getName(), getCurrentLoggedInUser());
        return Optional.of(productObject);

//        if (Optional.of(productObject) != null) {
//            throw new InformationExistException("Product already exists" );
//        } else {
//            productObject.setUser(getCurrentLoggedInUser());
//            return Optional.of(productRepository.save(productObject));
//        }
    }

    public static User getCurrentLoggedInUser() {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails.getUser();
    }


}