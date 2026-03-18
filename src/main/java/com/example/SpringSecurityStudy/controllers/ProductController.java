package com.example.SpringSecurityStudy.controllers;

import com.example.SpringSecurityStudy.dto.ProductRequestDTO;
import com.example.SpringSecurityStudy.model.Product;
import com.example.SpringSecurityStudy.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody ProductRequestDTO data) {
        Product newProduct = service.saveProduct(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }

    @RequestMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = service.findAll();
        return ResponseEntity.ok(products);
    }

}