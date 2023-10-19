package com.example.dermicyclebackend.controller;

import com.example.dermicyclebackend.models.Product;
import com.example.dermicyclebackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping(path="/api/users/")
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
     * @param productObject The Product object representing the product to be created.
     * @return A ResponseEntity indicating success or conflict along with a message and data.
     */
    @PostMapping(path = "/products/")
    public ResponseEntity<?> createProductUser(@RequestBody Product productObject) {
        Long userId = UserService.getCurrentLoggedInUser().getId();
        Optional<Product> productOptional =userService.createProductUser(userId, productObject);
        if (productOptional.isPresent()) {
            message.put("message", "success");
            message.put("data", productOptional.get());
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        } else {
            message.put("message", "Product already exists");
            return new ResponseEntity<>(message, HttpStatus.CONFLICT);
        }
    }
}
