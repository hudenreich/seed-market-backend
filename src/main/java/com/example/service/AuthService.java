package com.example.service;

import com.example.dto.JwtResponse;
import com.example.dto.LoginRequest; // Импортируем LoginRequest
import com.example.dto.SignupRequest; // Импортируем SignupRequest
import com.example.dto.MessageResponse; // Импортируем MessageResponse

public interface AuthService {


    JwtResponse authenticateUser(LoginRequest loginRequest);


    MessageResponse registerUser(SignupRequest signupRequest);
}