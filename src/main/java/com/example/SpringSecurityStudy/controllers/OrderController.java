package com.example.SpringSecurityStudy.controllers;

import com.example.SpringSecurityStudy.dto.OrderRequestDTO;
import com.example.SpringSecurityStudy.model.Order;
import com.example.SpringSecurityStudy.services.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/orders")
@Tag(name = "Orders", description = "Endpoints for viewing costumer orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @Operation(summary = "Get order by ID")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Integer id) {
        Order obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    @Operation(summary = "Place a new order", description = "Creates an order for the logged-in user")
    public ResponseEntity<Order> insert(@Valid @RequestBody OrderRequestDTO dto) {
        Order order = service.insert(dto);
        return ResponseEntity.status(201).body(order);
    }

}