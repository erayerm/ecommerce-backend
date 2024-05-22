package com.erayerm.ecommercebackend.dto;


import com.erayerm.ecommercebackend.entity.user.Role;
import lombok.Data;

@Data
public class UserRequest {
    private String name;
    private String email;
    private String password;
    private Role role;
}
