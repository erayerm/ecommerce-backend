package com.erayerm.ecommercebackend.dto;

import lombok.Data;

@Data
public class AddressRequest {
    //User'dan sonra tekrar düzenle
    private String addressTitle;
    private String name;
    private String phone;
    private String city;
    private String district;
    private String neighborhood;
    private String address;
    private Long userId;
}
