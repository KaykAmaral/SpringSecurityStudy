package com.example.SpringSecurityStudy.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record OrderItemRequestDTO(
        @NotNull
        Integer productId,

        @NotNull
        @Positive
        Integer quantity
) {}