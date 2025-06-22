package com.example.controller;

import com.example.dto.JwtResponse;
import com.example.dto.LoginRequest;
import com.example.dto.MessageResponse;
import com.example.dto.SignupRequest;
import com.example.service.AuthService;
import jakarta.validation.Valid; // Импорт для @Valid
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        return ResponseEntity.ok(authService.authenticateUser(loginRequest));
    }

    @PostMapping("/signup")
    public ResponseEntity<MessageResponse> registerUser(@Valid @RequestBody SignupRequest signupRequest) {

        authService.registerUser(signupRequest);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}