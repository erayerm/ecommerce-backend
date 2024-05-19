package com.erayerm.ecommercebackend.dto;

import lombok.Data;

import java.util.Set;

@Data
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer stock;
    private CategoryResponse category;
    private Double rating;
    private Integer sellCount;
    private Set<ImageResponse> images;
}
