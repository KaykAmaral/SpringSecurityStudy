package com.example.SpringSecurityStudy.services;

import com.example.SpringSecurityStudy.dto.UserRequestDTO;
import com.example.SpringSecurityStudy.dto.UserResponseDTO;
import com.example.SpringSecurityStudy.model.User;
import com.example.SpringSecurityStudy.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(Integer id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("User not found!"));
    }

    public void deleteUser(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repo.findByEmail(username);
    }

}