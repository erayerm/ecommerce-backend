package com.erayerm.ecommercebackend.service;

import com.erayerm.ecommercebackend.dto.ImageRequest;
import com.erayerm.ecommercebackend.dto.ImageResponse;
import com.erayerm.ecommercebackend.dto.ProductRequest;
import com.erayerm.ecommercebackend.entity.Image;
import com.erayerm.ecommercebackend.entity.Product;

import java.util.Set;

public interface ImageService {
    public Set<ImageResponse> getImagesByProductId(Long productId);
    public Image saveImage(ImageRequest imageRequest);
    public ImageResponse convertToResponse(Image image);

}
