package com.erayerm.ecommercebackend.dto;


import com.erayerm.ecommercebackend.entity.user.Role;
import lombok.Data;

import java.util.Set;

@Data
public class UserResponse {
    private String name;
    private String email;
    private String password;
    private Set<RoleResponse> roleResponse;
}
