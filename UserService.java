package com.room.service;

import com.room.entity.User;

public interface UserService {

    User login(String email, String password);
}
