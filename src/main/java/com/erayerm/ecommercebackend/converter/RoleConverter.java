package com.erayerm.ecommercebackend.converter;

import com.erayerm.ecommercebackend.dto.RoleResponse;
import com.erayerm.ecommercebackend.dto.UserResponse;
import com.erayerm.ecommercebackend.entity.user.Role;
import com.erayerm.ecommercebackend.entity.user.User;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter {
    public RoleResponse convertToResponse(Role role) {
        RoleResponse response = new RoleResponse();
        response.setId(role.getId());
        response.setAuthority(role.getAuthority());

        return response;
    }
}
