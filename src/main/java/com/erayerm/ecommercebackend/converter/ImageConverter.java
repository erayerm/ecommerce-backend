package com.erayerm.ecommercebackend.converter;

import com.erayerm.ecommercebackend.dto.ImageRequest;
import com.erayerm.ecommercebackend.dto.ImageResponse;
import com.erayerm.ecommercebackend.entity.Image;
import com.erayerm.ecommercebackend.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ImageConverter {
    private ProductService productService;
    public ImageResponse convertToResponse(Image image) {
        ImageResponse response = new ImageResponse();
        response.setId(image.getId());
        response.setUrl(image.getUrl());

        return response;
    }
    public Image convertRequestToEntity(ImageRequest imageRequest) {
        Image image = new Image();
        image.setUrl(imageRequest.getUrl());
        image.setProduct(productService.findProductById(imageRequest.getProductId()));
        return image;
    }
}
