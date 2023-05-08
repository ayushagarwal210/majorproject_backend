package com.speproject.majorproject.controller;

import com.speproject.majorproject.entity.JWTRequest;
import com.speproject.majorproject.entity.JWTResponse;
import com.speproject.majorproject.entity.User;
import com.speproject.majorproject.service.serviceImpl.UserServiceSecurityImpl;
import com.speproject.majorproject.utility.JWTUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class JWTController {

    private static final Logger logger = LoggerFactory.getLogger(JWTController.class);

    @Autowired
    private JWTUtility jwtUtility;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserServiceSecurityImpl userServiceSecurity;

    @PostMapping("/authenticate")
    public JWTResponse authenticate(@RequestBody JWTRequest jwtRequest) throws Exception{
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUsername(),
                            jwtRequest.getPassword()
                    )
            );
            logger.info("User authenticated successfully.");
        }
        catch (BadCredentialsException e){
            logger.error("Invalid credentials provided.");
            throw new Exception("Invalid Credentials");
        }
        final UserDetails userDetails=userServiceSecurity.loadUserByUsername(jwtRequest.getUsername());
        final String token=jwtUtility.generateToken(userDetails);
        return new JWTResponse(token);
    }
}
