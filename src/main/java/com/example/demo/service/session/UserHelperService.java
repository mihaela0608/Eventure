package com.example.demo.service.session;

import com.example.demo.model.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserHelperService {
    private static final String ROLE_PREFIX = "ROLE_";
    private final UserRepository userRepository;

    public UserHelperService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(){
        return userRepository.findByEmail(getUserDetails().getUsername())
                .orElse(null);
    }



    public UserDetails getUserDetails() {
        return (UserDetails) getAuthentication().getPrincipal();
    }
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

}
