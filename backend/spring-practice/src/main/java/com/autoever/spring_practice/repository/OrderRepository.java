package com.autoever.spring_practice.repository;

import com.autoever.spring_practice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
