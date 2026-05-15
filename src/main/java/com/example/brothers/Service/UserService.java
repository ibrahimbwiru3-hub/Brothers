package com.example.brothers.Service;

import com.example.brothers.Entity.User;

public interface UserService {
    User register(User user);
    User login(String email, String password);
}