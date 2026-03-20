package com.example.SpringSecurityStudy.controllers;

import com.example.SpringSecurityStudy.dto.UserResponseDTO;
import com.example.SpringSecurityStudy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<UserResponseDTO> users = service.findAll()
                .stream()
                .map(UserResponseDTO::new)
                .toList();
        return ResponseEntity.ok(users);
    }

}