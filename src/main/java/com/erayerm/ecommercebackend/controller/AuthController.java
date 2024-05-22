package com.erayerm.ecommercebackend.controller;

import com.erayerm.ecommercebackend.converter.UserConverter;
import com.erayerm.ecommercebackend.dto.RegisterUser;
import com.erayerm.ecommercebackend.dto.UserResponse;
import com.erayerm.ecommercebackend.entity.user.User;
import com.erayerm.ecommercebackend.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthController {
    private AuthenticationService authenticationService;
    private UserConverter userConverter;
    @PostMapping("/register")
    public UserResponse register(@RequestBody RegisterUser registerUser){
        return userConverter.convertToResponse(authenticationService.register(registerUser.name(), registerUser.email(), registerUser.password()));
    }
}
