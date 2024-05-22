package com.erayerm.ecommercebackend.converter;

import com.erayerm.ecommercebackend.dto.*;
import com.erayerm.ecommercebackend.entity.User;
import org.springframework.stereotype.Component;


@Component
public class UserConverter {

    public UserResponse convertToResponse(User user) {
        UserResponse response = new UserResponse();
        response.setEmail(user.getEmail());
        response.setPassword(user.getPassword());
        response.setName(user.getName());

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
