package com.example.dermicyclebackend.security;

import com.example.dermicyclebackend.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class JwtRequestFilter {
    Logger logger = Logger.getLogger(JwtRequestFilter.class.getName());

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    /**
     * Set the JWT utility class.
     *
     * @param jwtUtils The JWT utility class to set.
     */
    @Autowired
    public void setJwtUtils(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

}
