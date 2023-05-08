package com.speproject.majorproject.service;

import com.speproject.majorproject.entity.User;

import java.util.List;
import java.util.Optional;


public interface UserService {
    public User addUser(User user);

    List<User> getAllUser();

    Optional<User> getUserById(Long userId);

    User signInUser(String email, String password);

}
