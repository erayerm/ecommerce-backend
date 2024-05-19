package com.erayerm.ecommercebackend.dto;

import lombok.Data;

@Data
public class ProductRequest {
    private String name;
    private String description;
    private Double price;
    private Integer stock;
    private Long categoryId;
    private Double rating;
    private Integer sellCount;
}
