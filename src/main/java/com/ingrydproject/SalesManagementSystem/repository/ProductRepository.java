package com.ingrydproject.SalesManagementSystem.repository;

import com.ingrydproject.SalesManagementSystem.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findProductByName(String name);
    List<Product> findProductByPrice(int price);
}