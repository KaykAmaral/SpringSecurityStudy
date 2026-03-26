package com.example.SpringSecurityStudy.services;

import com.example.SpringSecurityStudy.dto.OrderItemRequestDTO;
import com.example.SpringSecurityStudy.dto.OrderRequestDTO;
import com.example.SpringSecurityStudy.model.*;
import com.example.SpringSecurityStudy.repositories.OrderItemRepository;
import com.example.SpringSecurityStudy.repositories.OrderRepository;
import com.example.SpringSecurityStudy.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Transactional
    public Order insert(OrderRequestDTO dto) {
        User client = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Order order = new Order();
        order = orderRepository.save(order);

        for (OrderItemRequestDTO itemDto : dto.items()) {
            Product product = productRepository.findById(itemDto.productId())
                    .orElseThrow(() -> new RuntimeException("Product not found: " +  itemDto.productId()));

            OrderItem item = new OrderItem(order, product, itemDto.quantity(), product.getPrice());
            orderItemRepository.save(item);

            order.getItems().add(item);

        }

        return order;

    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Integer id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not Found"));
    }

}