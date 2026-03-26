package com.example.SpringSecurityStudy.repositories;

import com.example.SpringSecurityStudy.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {



}