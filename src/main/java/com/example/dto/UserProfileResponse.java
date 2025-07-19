package com.example.dto;

import com.example.entity.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserProfileResponse {
    private Long id;
    private String username;
    private String email;
    private List<Role> roles;

    public UserProfileResponse(List<Role> roles, String email, String username, Long id) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }

}
