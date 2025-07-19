package com.example.service;

import com.example.dto.JwtResponse;
import com.example.dto.LoginRequest;
import com.example.dto.MessageResponse;
import com.example.dto.SignupRequest;
import com.example.entity.ERole;
<<<<<<< HEAD
import com.example.entity.Role;
=======
import com.example.entity.Role; // Убедитесь, что этот импорт есть
>>>>>>> origin/main
import com.example.entity.User;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;
import com.example.security.jwt.JwtUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
<<<<<<< HEAD
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
=======

import java.util.HashSet;
import java.util.List; // Импорт для List
import java.util.Set;
import java.util.stream.Collectors; // Импорт для Collectors
>>>>>>> origin/main

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
<<<<<<< HEAD
    private final UserDetailsServiceImpl userDetailsService;

    public AuthServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager,
                           JwtUtils jwtUtils,
                           UserDetailsServiceImpl userDetailsService) {
=======

    public AuthServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager,
                           JwtUtils jwtUtils) {
>>>>>>> origin/main
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
<<<<<<< HEAD
        this.userDetailsService = userDetailsService;
=======
>>>>>>> origin/main
    }

    @Override
    public JwtResponse authenticateUser(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

<<<<<<< HEAD
        UserDetails principal = (UserDetails) authentication.getPrincipal();

        UserDetailsImpl userDetails;
        if (principal instanceof UserDetailsImpl) {
            userDetails = (UserDetailsImpl) principal;
        } else {
            userDetails = (UserDetailsImpl) userDetailsService.loadUserByUsername(principal.getUsername());
        }

=======
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        // Получаем роли пользователя и преобразуем их в List<String>
>>>>>>> origin/main
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

<<<<<<< HEAD
=======
        // Теперь передаем роли в конструктор JwtResponse
>>>>>>> origin/main
        return new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles);
    }


    @Override
    public MessageResponse registerUser(SignupRequest signupRequest) {
        if (userRepository.existsByUsername(signupRequest.getUsername())) {
            return new MessageResponse("Error: Username is already taken!");
        }

        if (userRepository.existsByEmail(signupRequest.getEmail())) {
            return new MessageResponse("Error: Email is already in use!");
        }

        User user = new User(signupRequest.getUsername(),
                signupRequest.getEmail(),
                passwordEncoder.encode(signupRequest.getPassword()));

        Set<Role> roles = new HashSet<>();
<<<<<<< HEAD

=======
        // Убедитесь, что findByName возвращает Optional<Role>
>>>>>>> origin/main
        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        roles.add(userRole);
        user.setRoles(roles);

        userRepository.save(user);

        return new MessageResponse("User registered successfully!");
    }
}