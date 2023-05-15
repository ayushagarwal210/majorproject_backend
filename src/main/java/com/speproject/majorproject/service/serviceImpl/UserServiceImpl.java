package com.speproject.majorproject.service.serviceImpl;

import com.speproject.majorproject.entity.Book;
import com.speproject.majorproject.entity.User;
import com.speproject.majorproject.exceptions.InvalidCredentialsException;
import com.speproject.majorproject.repository.UserRepository;
import com.speproject.majorproject.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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
    public User signInUser(String email,String password) throws InvalidCredentialsException {
        logger.info("Logging in user with email " + email);
        Optional<User> user = userRepository.findByEmailAndPassword(email,password);
        if(!user.isPresent()) {
            throw new InvalidCredentialsException("Invalid User name or password");
        }
        return user.get();
    }
    @Override
    public User updateUser(Long userId, User user) {
        User userDB = userRepository.findById(userId).get();
        if(Objects.nonNull(user.getName()) && !"".equalsIgnoreCase(user.getName())){
            userDB.setName(user.getName());
        }
        if(Objects.nonNull(user.getPassword()) && !"".equalsIgnoreCase(user.getPassword())){
            userDB.setPassword(user.getPassword());
        }
        if(Objects.nonNull(user.getEmail()) && !"".equalsIgnoreCase(user.getEmail())){
            userDB.setEmail(user.getEmail());
        }
        if(Objects.nonNull(user.getPhoneNumber()) && !"".equalsIgnoreCase(user.getPhoneNumber())){
            userDB.setPhoneNumber(user.getPhoneNumber());
        }
        if(Objects.nonNull(user.getAddress()) && !"".equalsIgnoreCase(user.getAddress())){
            userDB.setAddress(user.getAddress());
        }

        return userRepository.save(userDB);
    }
}
