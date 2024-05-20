package com.erayerm.ecommercebackend.service;

import com.erayerm.ecommercebackend.dto.*;
import com.erayerm.ecommercebackend.entity.Category;
import com.erayerm.ecommercebackend.entity.Image;
import com.erayerm.ecommercebackend.entity.Product;
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
    private ProductService productService;

    public Set<ImageResponse> getImagesByProductId(Long productId){
        List<Image> imageList = imageRepository.findByProductId(productId);
        return imageList.stream().map(this::convertToResponse).collect(Collectors.toSet());
    }

    public Image saveImage(ImageRequest imageRequest){
        Image image = convertRequestToEntity(imageRequest);
        return imageRepository.save(image);
    }
    public ImageResponse convertToResponse(Image image) {
        ImageResponse response = new ImageResponse();
        response.setId(image.getId());
        response.setUrl(image.getUrl());

        return response;
    }

    private Image convertRequestToEntity(ImageRequest imageRequest) {
        Image image = new Image();
        image.setUrl(imageRequest.getUrl());
        image.setProduct(productService.findProductById(imageRequest.getProductId()));
        return image;
    }

}
