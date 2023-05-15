//package com.speproject.majorproject.service;
//
//import com.speproject.majorproject.entity.User;
//import com.speproject.majorproject.repository.UserRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class UserServiceTest {
//
//    @Autowired
//    public UserService userService;
//
//    @MockBean
//    private UserRepository userRepository;
//
//    @BeforeEach
//    void setUp() {
//        User user = User.builder().userId(1L).name("akshat").address("Bombay").email("akshatkarodiya@gmail.com").password("abc").phoneNumber("8085133501").isAdmin(true).build();
//        Mockito.when(userRepository.findById(1l)).thenReturn(Optional.ofNullable(user));
//    }
//
//    @Test
//    public void whenValidUserId_thenUserShouldFound() {
//        long userID = 1;
//        User found = userService.getUserById(userID).get();
//        assertEquals(userID,found.getUserId());
//    }
//
//}