package com.erayerm.ecommercebackend.controller;

import com.erayerm.ecommercebackend.converter.ImageConverter;
import com.erayerm.ecommercebackend.dto.ImageRequest;
import com.erayerm.ecommercebackend.dto.ImageResponse;
import com.erayerm.ecommercebackend.dto.ProductRequest;
import com.erayerm.ecommercebackend.dto.ProductResponse;
import com.erayerm.ecommercebackend.entity.Image;
import com.erayerm.ecommercebackend.entity.Product;
import com.erayerm.ecommercebackend.service.ImageService;
import com.erayerm.ecommercebackend.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/images")
public class ImageController {
    private ImageService imageService;
    private final ImageConverter imageConverter;

    @PostMapping("/")
    public ImageResponse createImage(@RequestBody ImageRequest imageRequest) {
        Image image = imageService.saveImage(imageRequest);
        return imageConverter.convertToResponse(image);
    }

}
