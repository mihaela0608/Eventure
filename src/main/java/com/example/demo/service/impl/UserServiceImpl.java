package com.example.demo.service.impl;

import com.example.demo.model.dto.UserRegistrationDto;
import com.example.demo.model.entity.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final RoleRepository roleRepository;

    public UserServiceImpl (UserRepository userRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
        this.roleRepository = roleRepository;
    }

    @Override
    public boolean registeredUser (UserRegistrationDto userRegistrationDto) {
        if (userRepository.findByEmail(userRegistrationDto.getEmail()).isPresent()){
            return false;
        }
        User user = getUser(userRegistrationDto);
        userRepository.saveAndFlush(user);
        return true;
    }

    private User getUser (UserRegistrationDto userRegistrationDto) {
        User user = modelMapper.map(userRegistrationDto, User.class);
        user.setRole(roleRepository.findByName("USER").get());
        if (userRepository.count() == 0){
            user.setRole(roleRepository.findByName("ADMIN").get());
        }
        user.setPassword(passwordEncoder.encode(userRegistrationDto.getPassword()));
        return user;
    }
}
