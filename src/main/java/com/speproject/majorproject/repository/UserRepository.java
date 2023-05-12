package com.speproject.majorproject.repository;

import com.speproject.majorproject.entity.User;
import com.speproject.majorproject.exceptions.InvalidCredentialsException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmailAndPassword(String email, String password);

    User findByEmail(String email);
}
