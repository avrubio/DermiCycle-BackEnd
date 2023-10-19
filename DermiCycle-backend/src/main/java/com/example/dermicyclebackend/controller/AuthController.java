package com.example.dermicyclebackend.controller;

import com.example.dermicyclebackend.models.User;
import com.example.dermicyclebackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path ="/auth/users/") // http://localhost:0317/auth/user
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
    @PostMapping("/register") // http://localhost:0317/auth/users/register/
    public User createUser(@RequestBody User userObject) {
        return userService.createUser(userObject);
    }
}
