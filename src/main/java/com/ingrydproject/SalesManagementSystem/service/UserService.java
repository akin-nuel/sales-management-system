package com.ingrydproject.SalesManagementSystem.service;

import com.ingrydproject.SalesManagementSystem.dto.UserDto;
import com.ingrydproject.SalesManagementSystem.model.User;
import com.ingrydproject.SalesManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @CacheEvict(value = "allUsers", allEntries = true)
    public String addUser(UserDto userDto){
        User user1 = new User(userDto.getFullName(), userDto.getEmail(), userDto.getRole(), userDto.getPhoneNumber(), userDto.getAddress());
        userRepository.save(user1);
        return "User Successfully added";
    }

    @Cacheable("allUsers")
    //public List<User> getAllUser(){
    //    return userRepository.findAll();
   // }
    public Page<User> findPage(int pageNumber){
        Pageable pageable = PageRequest.of(pageNumber - 1,5);
        return userRepository.findAll(pageable);
    }

    @Cacheable(value = "singleUsers", key = "#id")
    public User findUserById(int id){
        return userRepository.findById(id).get();
    }

    @CacheEvict(value = {"singleUsers", "allUsers"}, allEntries = true)
    public String deleteUser(int id){
        User toDelete = userRepository.findById(id).get();
        userRepository.delete(toDelete);
        return "User has been deleted";
    }

    public User findUserByEmail(String email){
        User user = userRepository.findUserByEmail(email);
        return user;
    }


    @CacheEvict(value = {"singleUsers", "allUsers"}, allEntries = true)
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
