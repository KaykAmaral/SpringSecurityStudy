package com.example.SpringSecurityStudy.dto;

import com.example.SpringSecurityStudy.model.User;

public record UserResponseDTO(Integer id, String name, String email) {

    public UserResponseDTO(User user) {
        this(user.getId(), user.getName(), user.getEmail());
    }

}