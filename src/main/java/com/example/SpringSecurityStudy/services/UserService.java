package com.example.SpringSecurityStudy.services;

import com.example.SpringSecurityStudy.dto.UserRequestDTO;
import com.example.SpringSecurityStudy.dto.UserResponseDTO;
import com.example.SpringSecurityStudy.model.User;
import com.example.SpringSecurityStudy.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public UserResponseDTO saveUser(@Valid UserRequestDTO data) {

        User user = new User();
        user.setName(data.name());
        user.setEmail(data.email());
        user.setPassword(data.password()); // I'll make the encoder here (BCrypt)

        repo.save(user);
        return new  UserResponseDTO(user);
    }

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(Integer id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("User not found!"));
    }

    public void deleteUser(Integer id) {
        repo.deleteById(id);
    }

}