package com.example.dermicyclebackend.controller;

import com.example.dermicyclebackend.exception.InformationExistException;
import com.example.dermicyclebackend.request.ProductWithStage;
import com.example.dermicyclebackend.response.ProductWithStageResponse;
import com.example.dermicyclebackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {
    private UserService userService;

    /**
     * Constructor-based autowiring of the UserService dependency.
     *
     * @param userService The UserService implementation to be injected.
     */
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    static HashMap<String, Object> message = new HashMap<>();

    /**
     * Endpoint for creating a new product under the current user
     *
     * @return A ResponseEntity indicating success or conflict along with a message and data.
     */
    @PostMapping(path = "/products/")
    public ResponseEntity<?> createProductUser(@RequestBody ProductWithStage productWithStageObject) {
        try {
            ProductWithStageResponse product = userService.createProductUserWithStage(productWithStageObject);
            message.put("message", "success");
            message.put("data", product);
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        } catch (InformationExistException e) {
            message.put("message", "Product already exists");
            return new ResponseEntity<>(message, HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/hello")
    public ResponseEntity<?> hello() {
        message.put("message", "success");
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

}
