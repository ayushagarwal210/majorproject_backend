package com.speproject.majorproject.service;

import com.speproject.majorproject.entity.Book;
import com.speproject.majorproject.entity.User;
import com.speproject.majorproject.exceptions.InvalidCredentialsException;

import java.util.List;
import java.util.Optional;


public interface UserService {
    public User addUser(User user);

    List<User> getAllUser();

    Optional<User> getUserById(Long userId);

    User signInUser(String email, String password) throws InvalidCredentialsException;


    public User updateUser(Long bookId, User user);
}
