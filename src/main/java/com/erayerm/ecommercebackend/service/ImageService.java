package com.erayerm.ecommercebackend.service;

import com.erayerm.ecommercebackend.dto.ImageResponse;

import java.util.Set;

public interface ImageService {
    public Set<ImageResponse> getImagesByProductId(Long productId);
}
