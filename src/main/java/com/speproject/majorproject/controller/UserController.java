package com.speproject.majorproject.controller;

import com.speproject.majorproject.entity.User;
import com.speproject.majorproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/registerUser")
    public User registerUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PostMapping("/loginUser")
    public User loginUser(@RequestParam String email,@RequestParam String password){
        return userService.loginUser(email, password);
    }

    @GetMapping("/getUsers")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping("/getUsers/{id}")
    public Optional<User> getUserById(@PathVariable("id") Long userId){
        return userService.getUserById(userId);
    }


}
