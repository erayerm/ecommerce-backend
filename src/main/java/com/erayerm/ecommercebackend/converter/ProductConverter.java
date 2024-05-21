package com.erayerm.ecommercebackend.converter;

import com.erayerm.ecommercebackend.dto.CategoryResponse;
import com.erayerm.ecommercebackend.dto.ImageResponse;
import com.erayerm.ecommercebackend.dto.ProductRequest;
import com.erayerm.ecommercebackend.dto.ProductResponse;
import com.erayerm.ecommercebackend.entity.Category;
import com.erayerm.ecommercebackend.entity.Image;
import com.erayerm.ecommercebackend.entity.Product;
import com.erayerm.ecommercebackend.repository.CategoryRepository;
import com.erayerm.ecommercebackend.repository.ImageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ProductConverter {
    private ImageRepository imageRepository;
    private CategoryRepository categoryRepository;

    public ProductResponse convertToResponse(Product product) {
        ProductResponse response = new ProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setDescription(product.getDescription());
        response.setPrice(product.getPrice());
        response.setStock(product.getStock());
        response.setRating(product.getRating());
        response.setSellCount(product.getSellCount());
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setId(product.getCategory().getId());
        categoryResponse.setCode(product.getCategory().getCode());
        categoryResponse.setTitle(product.getCategory().getTitle());
        categoryResponse.setImg(product.getCategory().getImg());
        categoryResponse.setRating(product.getCategory().getRating());
        categoryResponse.setGender(product.getCategory().getGender());
        response.setCategory(categoryResponse);
        response.setImages(imageRepository.findByProductId(product.getId()).stream().map(this::convertToResponse).collect(Collectors.toList()));

        return response;
    }

    public ImageResponse convertToResponse(Image image) {
        ImageResponse response = new ImageResponse();
        response.setId(image.getId());
        response.setUrl(image.getUrl());

        return response;
    }


    public Product convertRequestToEntity(ProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        product.setStock(productRequest.getStock());
        product.setRating(productRequest.getRating());
        product.setSellCount(productRequest.getSellCount());

        Category category = categoryRepository.findById(productRequest.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        product.setCategory(category);

        return product;
    }

}