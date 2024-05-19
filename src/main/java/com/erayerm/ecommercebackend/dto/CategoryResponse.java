package com.erayerm.ecommercebackend.dto;

import lombok.Data;

@Data
public class CategoryResponse {
    private Long id;
    private String code;
    private String title;
    private String img;
    private Double rating;
    private String gender;
}
