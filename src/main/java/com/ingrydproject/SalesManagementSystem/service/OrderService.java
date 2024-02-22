package com.ingrydproject.SalesManagementSystem.service;

import com.ingrydproject.SalesManagementSystem.dto.OrderDto;
import com.ingrydproject.SalesManagementSystem.model.Order;
import com.ingrydproject.SalesManagementSystem.model.User;
import com.ingrydproject.SalesManagementSystem.repository.OrderRepository;
import com.ingrydproject.SalesManagementSystem.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    @Cacheable("orders")
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    @CacheEvict(value = "orders", allEntries = true)
    public String addOrder(OrderDto orderDto){
        User user = userRepository.findUserByEmail(orderDto.getEmail());
        Date date = new Date();
        Order order1 = new Order();

        order1.setUser(user);
        order1.setDate(date);
        order1.setStatus(orderDto.getStatus());
        order1.setAmount(orderDto.getAmount());

        orderRepository.save(order1);

        return "order successfully added";
    }

    @CacheEvict(value = {"orders", "id"}, allEntries = true)
    public String updateOrders(Long id, OrderDto orderDto){
        User user = userRepository.findUserByEmail(orderDto.getEmail());
        Date date = new Date();
        Order order = findOrderById(id);

        order.setUser(user);
        order.setDate(date);
        order.setStatus(orderDto.getStatus());
        order.setAmount(orderDto.getAmount());

        orderRepository.save(order);
        return "Order successfully updated";
    }

    @CacheEvict(value = {"orders", "id"}, allEntries = true)
    public String deleteOrder(Long id){
        orderRepository.deleteById(id);
        return "Deleted successfully";
    }

    public Order findOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow();
    }
}
