package com.speproject.majorproject.service.serviceImpl;

import com.speproject.majorproject.entity.User;
import com.speproject.majorproject.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceSecurityImpl implements UserDetailsService {

    private static final Logger logger = LogManager.getLogger(UserServiceSecurityImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        logger.info("User with email {} is found", email);
        if (user == null) {
            logger.error("User with email {} not found", email);
            throw new UsernameNotFoundException("User with email " + email + " not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }
}
