package com.example.SpringSecurityStudy.controllers;

import com.example.SpringSecurityStudy.dto.UserRequestDTO;
import com.example.SpringSecurityStudy.dto.UserResponseDTO;
import com.example.SpringSecurityStudy.model.User;
import com.example.SpringSecurityStudy.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO data) {
        UserResponseDTO user = service.saveUser(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(service.findAll());
    }

}