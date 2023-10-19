package com.example.dermicyclebackend.service;


import com.example.dermicyclebackend.exception.InformationExistException;
import com.example.dermicyclebackend.models.User;
import com.example.dermicyclebackend.repository.UserRepository;
import com.example.dermicyclebackend.security.JwtUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

   private final JwtUtils jwtUtils;
   private AuthenticationManager authenticationManager;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtils jwtUtils, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
    }

    public User createUser(User userObject) {
        if(!userRepository.existsByEmailAddress(userObject.getEmailAddress())) {
            userObject.setPassword(passwordEncoder.encode(userObject.getPassword()));
            return userRepository.save(userObject);

        }else {
            throw new InformationExistException("user with email address " + userObject.getEmailAddress() + " already exists!")
        }
    }
}

