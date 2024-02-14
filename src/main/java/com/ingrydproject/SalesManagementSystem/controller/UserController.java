package com.ingrydproject.SalesManagementSystem.controller;

import com.ingrydproject.SalesManagementSystem.dto.UserDto;
import com.ingrydproject.SalesManagementSystem.model.User;
import com.ingrydproject.SalesManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/User")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> saveUser(){
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }

    @PostMapping("save-user")
    public ResponseEntity<String> addUser(@RequestBody UserDto userDto){
        userService.addUser(userDto);
        return new ResponseEntity<>("User had been successfully created", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id){
        return new ResponseEntity<>(userService.findUserById(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        return ResponseEntity.ok(userService.deleteUser(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, UserDto userDto){
        return ResponseEntity.ok(userService.updateUser(id, userDto));
    }

    @GetMapping("/{email}")
    public Optional<User> findUserByEmail(@PathVariable String email){
        return userService.findUserByEmail(email);
    }
}
