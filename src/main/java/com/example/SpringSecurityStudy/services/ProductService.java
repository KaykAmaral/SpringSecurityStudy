package com.example.SpringSecurityStudy.services;

import com.example.SpringSecurityStudy.model.Product;
import com.example.SpringSecurityStudy.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public Product save(Product product) {
        if (product.getPrice().doubleValue() <= 0) throw new RuntimeException("The price can't be zero or negative");
        return repo.save(product);
    }

    public Product findById(Integer id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Product not found!"));
    }

    public List<Product> findAll() {
        return repo.findAll();
    }

    public void deleteProduct(Integer id) {
        repo.deleteById(id);
    }

    public Product updateStock(Integer id, Integer quantity) {
        Product product = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found!"));

        product.setStockQuantity(quantity);
        return repo.save(product);
    }

}