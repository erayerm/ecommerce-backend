package com.erayerm.ecommercebackend.dto;

import com.erayerm.ecommercebackend.entity.Image;
import jakarta.persistence.Column;
import lombok.Data;

import java.util.List;

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
