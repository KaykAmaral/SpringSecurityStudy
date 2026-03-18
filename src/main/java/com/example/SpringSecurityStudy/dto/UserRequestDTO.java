package com.example.SpringSecurityStudy.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequestDTO(
        @NotBlank(message = "The name can't be null")
        String name,

        @Email(message = "Invalid email")
        @NotBlank(message = "The email can  t be null")
        String email,

        @NotBlank(message = "The password can't be null")
        @Size(min = 6, message = "Min 6 chars")
        String password
) {}