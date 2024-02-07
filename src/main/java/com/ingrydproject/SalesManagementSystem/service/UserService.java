package com.ingrydproject.SalesManagementSystem.service;

import com.ingrydproject.SalesManagementSystem.dto.UserDto;
import com.ingrydproject.SalesManagementSystem.model.User;
import com.ingrydproject.SalesManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String addUser(UserDto userDto){
        User user1 = new User(userDto.getFullName(), userDto.getEmail(), userDto.getRole(), userDto.getPhoneNumber(), userDto.getAddress());
        userRepository.save(user1);
        return "User Successfully added";
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public User findUserById(int id){
        return userRepository.findById(id).get();
    }

    public String deleteUser(int id){
        User toDelete = userRepository.findById(id).get();
        userRepository.delete(toDelete);
        return "User has been deleted";
    }

    public User updateUser (int id, UserDto userDto){
        User user = userRepository.findById(id).get();

        user.setAddress(userDto.getAddress());
        user.setRole(userDto.getRole());
        user.setEmail(userDto.getEmail());
        user.setFullName(userDto.getFullName());
        user.setPhoneNumber(userDto.getPhoneNumber());

        return userRepository.save(user);
    }

}
