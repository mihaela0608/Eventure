package com.example.demo.service;


import com.example.demo.model.dto.UserRegistrationDto;

public interface UserService {
    boolean registerUser(UserRegistrationDto userRegistrationDto);
}
