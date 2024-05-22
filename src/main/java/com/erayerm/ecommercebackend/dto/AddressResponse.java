package com.erayerm.ecommercebackend.dto;

import com.erayerm.ecommercebackend.entity.Order;
import com.erayerm.ecommercebackend.entity.user.User;
import lombok.Data;

import java.util.List;

@Data
public class AddressResponse {
    //User'dan sonra tekrar düzenle
    private String addressTitle;
    private String name;
    private String phone;
    private String city;
    private String district;
    private String neighborhood;
    private String address;
    private User user;
    private List<Order> order;
}
