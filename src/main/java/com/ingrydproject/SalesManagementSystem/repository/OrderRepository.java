package com.ingrydproject.SalesManagementSystem.repository;

import com.ingrydproject.SalesManagementSystem.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
