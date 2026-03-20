package com.example.SpringSecurityStudy.dto;

import com.example.SpringSecurityStudy.model.enums.UserRole;
import jakarta.validation.constraints.NotBlank;

public record RegisterDTO(

        @NotBlank
        String name,

        @NotBlank
        String email,

        @NotBlank
        String password,

        UserRole role
) {}