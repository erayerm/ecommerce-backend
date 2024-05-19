package com.erayerm.ecommercebackend.service;

import com.erayerm.ecommercebackend.dto.ImageResponse;
import com.erayerm.ecommercebackend.entity.Image;
import com.erayerm.ecommercebackend.repository.ImageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ImageServiceImpl implements ImageService {
    private ImageRepository imageRepository;

    public Set<ImageResponse> getImagesByProductId(Long productId){
        List<Image> imageList = imageRepository.findByProductId(productId);
        return imageList.stream().map(this::convertToResponse).collect(Collectors.toSet());
    }

    public ImageResponse convertToResponse(Image image) {
        ImageResponse response = new ImageResponse();
        response.setId(image.getId());
        response.setUrl(image.getUrl());

        return response;
    }
}
