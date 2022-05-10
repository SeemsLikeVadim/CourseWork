package com.example.coursework.service;

import com.example.coursework.model.User;
import com.example.coursework.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}
