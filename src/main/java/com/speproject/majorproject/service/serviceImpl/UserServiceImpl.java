package com.speproject.majorproject.service.serviceImpl;
import com.speproject.majorproject.entity.User;
import com.speproject.majorproject.repository.UserRepository;
import com.speproject.majorproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user){
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long userId){
        return userRepository.findById(userId);
    }

    @Override
    public User loginUser(String email,String password){
        return userRepository.findByEmailAndPassword(email,password);
    }
}
