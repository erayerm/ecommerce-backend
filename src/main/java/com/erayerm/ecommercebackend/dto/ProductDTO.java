package com.erayerm.ecommercebackend.dto;

import com.erayerm.ecommercebackend.entity.Category;
import com.erayerm.ecommercebackend.entity.Image;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer stock;
    private Long categoryId;
    private String categoryCode;
    private Double rating;
    private Integer sellCount;
    private Set<Image> image;
}
