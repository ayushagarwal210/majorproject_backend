package com.speproject.majorproject.service.serviceImpl;

import com.speproject.majorproject.entity.User;
import com.speproject.majorproject.repository.UserRepository;
import com.speproject.majorproject.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user){
        logger.info("Adding user with id " + user.getUserId());
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser(){
        logger.info("Fetching all users");
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long userId){
        logger.info("Fetching user with id " + userId);
        return userRepository.findById(userId);
    }

    @Override
    public User loginUser(String email,String password){
        logger.info("Logging in user with email " + email);
        return userRepository.findByEmailAndPassword(email,password);
    }
}
