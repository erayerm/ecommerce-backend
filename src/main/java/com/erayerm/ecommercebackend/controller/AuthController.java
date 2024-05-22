package com.erayerm.ecommercebackend.controller;

import com.erayerm.ecommercebackend.dto.RegisterUser;
import com.erayerm.ecommercebackend.entity.user.User;
import com.erayerm.ecommercebackend.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public User register(@RequestBody RegisterUser registerUser){
        return authenticationService.register(registerUser.name(), registerUser.email(), registerUser.password());
    }
}
