package com.example.dto;

import jakarta.validation.constraints.Email;   // Импорт для @Email
import jakarta.validation.constraints.NotBlank; // Импорт для @NotBlank
import jakarta.validation.constraints.Size;   // Импорт для @Size
import lombok.Getter;
import lombok.Setter;

import java.util.Set; // Импорт для Set


@Setter
@Getter
public class SignupRequest {

    @NotBlank(message = "Username cannot be empty")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
    private String username;

    @NotBlank(message = "Email cannot be empty")
    @Size(max = 50, message = "Email cannot exceed 50 characters")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password cannot be empty")
    @Size(min = 6, max = 40, message = "Password must be between 6 and 40 characters")
    private String password;

    // Если вы ожидаете роли от фронтенда (обычно нет, но для гибкости можно оставить)
    // private Set<String> role;

    /* Если вы будете принимать роли из запроса
    public Set<String> getRole() {
        return role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }
    */
}