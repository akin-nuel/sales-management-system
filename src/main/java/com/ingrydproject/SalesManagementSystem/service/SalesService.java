package com.ingrydproject.SalesManagementSystem.service;

import com.ingrydproject.SalesManagementSystem.dto.SalesDto;
import com.ingrydproject.SalesManagementSystem.model.Sales;
import com.ingrydproject.SalesManagementSystem.model.User;
import com.ingrydproject.SalesManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesService {

    @Autowired
    private UserRepository userRepository;


    public Sales addSales(SalesDto sales){
//        Sales sales1 = new Sales();
//        User user =
    }
}
