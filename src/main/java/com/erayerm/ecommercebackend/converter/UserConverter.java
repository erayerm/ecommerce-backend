package com.erayerm.ecommercebackend.converter;

import com.erayerm.ecommercebackend.dto.*;
import com.erayerm.ecommercebackend.entity.user.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;


@Component
@AllArgsConstructor
public class UserConverter {
    private RoleConverter roleConverter;
    public UserResponse convertToResponse(User user) {
        UserResponse response = new UserResponse();
        response.setEmail(user.getEmail());
        response.setPassword(user.getPassword());
        response.setName(user.getName());
        response.setRoleResponse(user.getAuthorities().stream().map(roleConverter::convertToResponse).collect(Collectors.toSet()));
        return response;
    }

    /*
    public UserResponse convertToResponse(User user) {
        UserResponse response = new UserResponse();
        response.setName(user.getName());
        response.setPhone(user.getPhone());
        response.setBankAccount(user.getBankAccount());
        response.setTaxNo(user.getTaxNo());
        return response;
    }
*/
/*
    public User convertRequestToEntity(UserRequest userRequest) {
        User user = new User();
        user.setName(userRequest.getName());
        user.setPhone(userRequest.getPhone());
        user

        return user;
    }

 */
}
