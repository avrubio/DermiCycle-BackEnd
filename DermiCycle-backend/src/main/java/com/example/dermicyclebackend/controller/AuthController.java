package com.example.dermicyclebackend.controller;

import com.example.dermicyclebackend.models.User;
import com.example.dermicyclebackend.request.LoginRequest;
import com.example.dermicyclebackend.request.RegisterRequest;
import com.example.dermicyclebackend.response.LoginResponse;
import com.example.dermicyclebackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path ="/auth/users") // http://localhost:0317/auth/user
public class AuthController {

    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    //CREATE USER
    /**
     * Endpoint for registering a new user.
     *
     * @param userObject The User object representing the user to be registered.
     * @return The registered User object.
     */
    @PostMapping("/register/") // http://localhost:0317/auth/users/register/
    public User createUser(@RequestBody RegisterRequest registerRequestObject) {
        return userService.createUser(registerRequestObject);
    }

    //LOGIN USER (Post)
    /**
     * Endpoint for authenticating and logging in a doctor.
     *
     * @param loginRequest The LoginRequest object containing login credentials.
     * @return A ResponseEntity containing a LoginResponse with a JWT token upon successful authentication.
     *         Returns UNAUTHORIZED status with an error message if authentication fails.
     */
    @PostMapping(path = "/login/") // http://localhost:0317/auth/users/login/
    public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequest loginRequest) {
        Optional<String> jwtToken = userService.loginUser(loginRequest);
        if (jwtToken.isPresent()) {
            return ResponseEntity.ok(new LoginResponse(jwtToken.get()));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new LoginResponse("Authentication failed"));
        }
    }
}