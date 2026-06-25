package com.room.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.room.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
User findByUsername(String username);
User findByEmailAndPassword(String email, String password);
}