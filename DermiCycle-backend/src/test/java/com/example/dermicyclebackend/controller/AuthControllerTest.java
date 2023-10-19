package com.example.dermicyclebackend.controller;

import com.example.dermicyclebackend.models.User;
import com.example.dermicyclebackend.repository.UserRepository;
import com.example.dermicyclebackend.request.LoginRequest;
import com.example.dermicyclebackend.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ComponentScan(basePackages = "com.example")
public class AuthControllerTest {

    @Autowired
    @MockBean
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Mock
    private UserRepository userRepository;

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private PasswordEncoder passwordEncoder;

    User RECORD_1 = new User(1L, "ariadna@ga.com", "password123");

    @Test
    public void createUser() throws Exception {
        when(userService.createUser(Mockito.any(User.class))).thenReturn(RECORD_1);

        mockMvc.perform(MockMvcRequestBuilders.post("/auth/users/register/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(RECORD_1)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value((RECORD_1.getId())))
                .andExpect(jsonPath("$.emailAddress").value(RECORD_1.getEmailAddress()))
                .andDo(print());
    }
    @Test
    public void loginUser() throws Exception {
        LoginRequest request = new LoginRequest();
        request.setEmailAddress("suresh123@gmail.com");
        request.setPassword("suresh123");
        Optional<String> token = Optional.of("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdWVyc2gxMjNAZ21haWwuY29tIiwiaWF0IjoxNjk2MDA4NTg5LCJleHAiOjE2OTYwOTQ5ODl9.nJDx67WgI5JZiFL_LFz4uFxFVgOR_nVPMCbrcY8Dcx8");
        when(userService.loginUser(Mockito.any(LoginRequest.class))).thenReturn(token);

        mockMvc.perform(MockMvcRequestBuilders.post("/auth/users/login/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.jwt").value(token.get()))
                .andDo(print());
    }

}
