package com.erayerm.ecommercebackend.service;

import com.erayerm.ecommercebackend.converter.ImageConverter;
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
    private final ImageConverter imageConverter;

    public Set<ImageResponse> getImagesByProductId(Long productId){
        List<Image> imageList = imageRepository.findByProductId(productId);
        return imageList.stream().map(imageConverter::convertToResponse).collect(Collectors.toSet());
    }
    public Image saveImage(ImageRequest imageRequest){
        Image image = imageConverter.convertRequestToEntity(imageRequest);
        return imageRepository.save(image);
    }
}
