package com.ingrydproject.SalesManagementSystem.controller;

import ch.qos.logback.core.model.Model;
import com.ingrydproject.SalesManagementSystem.dto.UserDto;
import com.ingrydproject.SalesManagementSystem.model.User;
import com.ingrydproject.SalesManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/User")
public class UserController {

    @Autowired
    private UserService userService;

   // @GetMapping("/allUsers")
   // public ResponseEntity<List<User>> saveUser(){
//       return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
//    }
   @GetMapping("/parameters/users")
   public String getAllPages(Model model){
       return getOnePage(model, 1);
   }
   @GetMapping("/parameters/users/page/{pageNumber}")
   public String getOnePage(Model model, @PathVariable("pageNumber") int currentPage){
       Page<User> page = userService.findPage(currentPage);
       int totalPages = page.getTotalPages();
       long totalItems = page.getTotalElements();
       List<User> countries = page.getContent();

       model.addText("currentPage");
       model.addText("totalPages");
       model.addText("totalItems");
       model.addText("countries");

       return "/parameters/countries";
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
    public ResponseEntity<User> findUserByEmail(@PathVariable String email){
        User user = userService.findUserByEmail(email);
        return new ResponseEntity<>(user, HttpStatusCode.valueOf(200));
    }
}
