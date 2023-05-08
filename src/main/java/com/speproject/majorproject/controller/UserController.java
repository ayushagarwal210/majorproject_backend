package com.speproject.majorproject.controller;

import com.speproject.majorproject.entity.User;
import com.speproject.majorproject.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/registerUser")
    public User registerUser(@RequestBody User user){
        logger.info("Registering user: {}", user);
        return userService.addUser(user);
    }

    @PostMapping("/loginUser")
    public User loginUser(@RequestParam String email,@RequestParam String password){
        logger.info("Logging in user with email: {}", email);
        return userService.loginUser(email, password);
    }

    @GetMapping("/getUsers")
    public List<User> getAllUser(){
        logger.info("Fetching all users");
        return userService.getAllUser();
    }

    @GetMapping("/getUsers/{id}")
    public Optional<User> getUserById(@PathVariable("id") Long userId){
        logger.info("Fetching user with ID: {}", userId);
        return userService.getUserById(userId);
    }
}
