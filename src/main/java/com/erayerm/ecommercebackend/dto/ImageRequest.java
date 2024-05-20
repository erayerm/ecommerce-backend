package com.erayerm.ecommercebackend.dto;

import lombok.Data;

@Data
public class ImageRequest {
    private String url;
    private Long productId;
}
