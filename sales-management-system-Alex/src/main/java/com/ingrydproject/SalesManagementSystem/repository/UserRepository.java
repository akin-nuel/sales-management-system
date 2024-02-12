package com.ingrydproject.SalesManagementSystem.repository;

import com.ingrydproject.SalesManagementSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserByEmail(String email);
}
