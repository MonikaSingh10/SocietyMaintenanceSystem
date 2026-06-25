package com.room.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.room.entity.User;
import com.room.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User login(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }
    
	public User getUser(String username) {
		return userRepository.findByUsername(username);
	}
}
