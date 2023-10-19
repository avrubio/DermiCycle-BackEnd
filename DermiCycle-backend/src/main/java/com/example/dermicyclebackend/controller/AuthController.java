package com.example.dermicyclebackend.controller;

import com.example.dermicyclebackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
