package com.example.SpringSecurityStudy.services;

import com.example.SpringSecurityStudy.model.User;
import com.example.SpringSecurityStudy.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User saveUser(User user) {
        // I'll make the encoder here (BCrypt)
        return repo.save(user);
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