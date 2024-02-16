package com.ingrydproject.SalesManagementSystem.controller;

import com.ingrydproject.SalesManagementSystem.dto.OrderDto;
import com.ingrydproject.SalesManagementSystem.model.Order;
import com.ingrydproject.SalesManagementSystem.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/order")
    public ResponseEntity<List<Order>> getAllOrders(){
        return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
    }

    @PostMapping("/order")
    public String addOrder(@Valid @RequestBody OrderDto orderDto){
        return orderService.addOrder(orderDto);
    }

    @PutMapping("/order/{id}")
    public String updateOrder(@PathVariable Long id, @Valid @RequestBody OrderDto orderDto){
        return orderService.updateOrders(id, orderDto);
    }

    @DeleteMapping("/order/{id}")
    public String deleteOrder(@PathVariable Long id){
        return orderService.deleteOrder(id);
    }

    @GetMapping("/order/id/{id}")
    @ResponseBody
    public Order findOrderById(Long id){
        return orderService.findOrderById(id);
    }
}
