package com.example.dermicyclebackend.controller;

import com.example.dermicyclebackend.exception.InformationExistException;
import com.example.dermicyclebackend.exception.InformationNotFoundException;
import com.example.dermicyclebackend.models.Product;
import com.example.dermicyclebackend.request.ProductWithStage;
import com.example.dermicyclebackend.response.ProductWithStageResponse;
import com.example.dermicyclebackend.response.SingleProductResponseWithStageForUser;
import com.example.dermicyclebackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

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
     * Endpoint for creating a new product under the current user.
     *
     * @param productWithStageObject The ProductWithStage object containing product details.
     * @return A ResponseEntity indicating success (HTTP 201 - Created) or conflict (HTTP 409 - Conflict)
     * along with a message and data.
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

    /**
     * Endpoint for getting a list of products in a specific stage for the current user.
     *
     * @param stageId The ID of the stage for which products are to be retrieved.
     * @return A ResponseEntity indicating success (HTTP 200 - OK) or not found (HTTP 404 - Not Found)
     * along with a message and data.
     */
    @GetMapping(path = "/stage/{stageId}/")
    public ResponseEntity<?> getSingleStageForUser(@PathVariable(value = "stageId") Long stageId) {
        try {
            List<SingleProductResponseWithStageForUser> productList = userService.getSingleStageForUser(stageId);
            message.put("message", "success");
            message.put("data", productList);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (InformationNotFoundException e) {
            message.put("message", "There are no products currently in this stage " + stageId);
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Endpoint for a simple "Hello" message.
     *
     * @return A ResponseEntity with a "success" message and HTTP 201 - Created status.
     */
    @GetMapping("/hello")
    public ResponseEntity<?> hello() {
        message.put("message", "success");
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }
}