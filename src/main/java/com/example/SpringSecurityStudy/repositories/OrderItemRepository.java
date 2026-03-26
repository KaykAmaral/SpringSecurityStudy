package com.example.SpringSecurityStudy.repositories;

import com.example.SpringSecurityStudy.model.OrderItem;
import com.example.SpringSecurityStudy.model.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {



}