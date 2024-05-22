package com.erayerm.ecommercebackend.service;

import com.erayerm.ecommercebackend.dto.UserRequest;
import com.erayerm.ecommercebackend.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public User createUserWithCart(UserRequest userRequest);
}
