package com.example.SpringSecurityStudy.controllers;

import com.example.SpringSecurityStudy.dto.UserResponseDTO;
import com.example.SpringSecurityStudy.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "Users", description = "User details & listing")
public class UserController {

    @Autowired
    private UserService service;

    @Operation(summary = "Get all users", description = "Returns a list of all registered users. Requires authentication.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "403", description = "Access denied")
    })
    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<UserResponseDTO> users = service.findAll()
                .stream()
                .map(UserResponseDTO::new)
                .toList();
        return ResponseEntity.ok(users);
    }

}