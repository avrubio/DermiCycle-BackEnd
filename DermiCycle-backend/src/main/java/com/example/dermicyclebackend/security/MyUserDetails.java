package com.example.dermicyclebackend.security;
import com.example.dermicyclebackend.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;

/**
 * Custom UserDetails implementation for User entities.
 */
public class MyUserDetails implements UserDetails {

    private final User user;

    /**
     * Constructs a new MyUserDetails instance with the provided User entity.
     *
     * @param user The User entity for which to create UserDetails.
     */
    public MyUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new HashSet<>(); // You can define authorities if needed.
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmailAddress();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    /**
     * Get the User entity associated with this UserDetails.
     *
     * @return The User entity.
     */
    public User getUser() {
        return user;
    }
}

