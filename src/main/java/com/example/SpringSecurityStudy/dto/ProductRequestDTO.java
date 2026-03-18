package com.example.SpringSecurityStudy.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record ProductRequestDTO(

        @NotBlank(message = "The name can't be null")
        String name,

        String description, // optional

        @NotNull(message = "The price can't be null")
        @Positive(message = "The price can't be zero or negative")
        BigDecimal price,

        @NotNull(message = "The stock can't be null")
        @PositiveOrZero(message = "The stock can't be negative")
        Integer stockQuantity
) {}