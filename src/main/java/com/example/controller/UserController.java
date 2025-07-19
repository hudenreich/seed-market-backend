package com.example.controller;


import com.example.dto.UserProfileResponse;
import com.example.service.AuthService;
import com.example.service.UserDetailsImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final AuthService authService;

    public UserController(AuthService authService) {
        this.authService = authService;
    }

//    @GetMapping("/me")
//    @PreAuthorize("hasRole('USER')")
//         public UserProfileResponse getCurrentUser(@AuthenticationPrincipal UserDetailsImpl userDetails){
//             return new UserProfileResponse(
//                     userDetails.getId(),
//                     userDetails.getUsername(),
//                     userDetails.getEmail(),
//                     userDetails.getAuthorities().stream()
//                             .map(auth -> auth.getAuthority())
//                             .collect(Collectors.toList())
//             );
//    }
}
