package com.example.dermicyclebackend.controller;

import com.example.dermicyclebackend.models.Product;
import com.example.dermicyclebackend.models.User;
import com.example.dermicyclebackend.security.MyUserDetails;
import com.example.dermicyclebackend.service.MyUserDetailsService;
import com.example.dermicyclebackend.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.Date;
import java.util.Optional;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ComponentScan(basePackages = "com.example")
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    private UserService userService;

    @MockBean
    private MyUserDetailsService myUserDetailsService;

    Product PRODUCT_1 = new Product(1L, "Test Snail Mucin", "Apply after toner");

    @Test
    @WithMockUser(username = "ariadna@ga.com")
    public void createProductUser() throws Exception {
        objectMapper.registerModule(new JavaTimeModule());

        when(userService.createProductUser(PRODUCT_1))
                .thenReturn(Optional.ofNullable(PRODUCT_1));

        MyUserDetails userDetails = setup();

        when(myUserDetailsService.loadUserByUsername("ariadna@ga.com")).thenReturn(userDetails);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/users/products/")
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + generateJwtToken())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(PRODUCT_1)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(print());
    }

    private String generateJwtToken() {
        // Create a JWT token with a specific subject and expiration time
        JwtBuilder jwtBuilder = Jwts.builder()
                .setIssuedAt(new Date())
                .setSubject("ariadna@ga.com")
                .setExpiration(new Date((new Date()).getTime() + 86400000))
                .signWith(SignatureAlgorithm.HS256, "C6UlILsE6GJwNqwCTkkvJj9O653yJUoteWMLfYyrc3vaGrrTOrJFAUD1wEBnnposzcQl");
        return jwtBuilder.compact();
    }

    private MyUserDetails setup() {
        User ariadnaRecord = new User(1L, "ariadna@ga.com", "password1234");
        return new MyUserDetails(ariadnaRecord);
    }
}