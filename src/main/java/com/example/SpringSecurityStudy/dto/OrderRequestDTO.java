package com.example.SpringSecurityStudy.dto;

import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record OrderRequestDTO(
        @NotEmpty
        List<OrderItemRequestDTO> items
) {}