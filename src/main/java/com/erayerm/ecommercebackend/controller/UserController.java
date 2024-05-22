package com.erayerm.ecommercebackend.controller;

import com.erayerm.ecommercebackend.converter.UserConverter;
import com.erayerm.ecommercebackend.dto.UserRequest;
import com.erayerm.ecommercebackend.dto.UserResponse;
import com.erayerm.ecommercebackend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    private UserConverter userConverter;

    @GetMapping("/")
    public List<UserResponse> getAllUsers(){
        return userService.getAllUsers().stream().map(userConverter::convertToResponse).toList();
    }

    @PostMapping("/")
    public UserResponse createNewUser(@RequestBody UserRequest userRequest){
        return userConverter.convertToResponse(userService.createUserWithCart(userRequest));
    }
}
