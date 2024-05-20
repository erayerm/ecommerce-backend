package com.erayerm.ecommercebackend.service;
import com.erayerm.ecommercebackend.dto.*;
import com.erayerm.ecommercebackend.entity.Category;
import com.erayerm.ecommercebackend.entity.Image;
import com.erayerm.ecommercebackend.entity.Product;
import com.erayerm.ecommercebackend.repository.CategoryRepository;
import com.erayerm.ecommercebackend.repository.ImageRepository;
import com.erayerm.ecommercebackend.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private ImageRepository imageRepository;
    public List<Product> getProductsByFilters(Long category, String filter, String sort, Integer limit, Integer offset){
        Pageable pageable = PageRequest.of(offset, limit);
        return productRepository.findProductsByFilters(category, filter, sort, pageable).toList();
    }

    public Product saveProduct(ProductRequest productRequest) {
        Product product = convertRequestToEntity(productRequest);
        return productRepository.save(product);
    }
    public Product findProductById(Long id){
        Optional<Product> productsOptional = productRepository.findById(id);
        if (productsOptional.isPresent()) {
            return productsOptional.get();
        }
        //throw exception
        return null;
    }

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

    private Product convertRequestToEntity(ProductRequest productRequest) {
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

    public ImageResponse convertToResponse(Image image) {
        ImageResponse response = new ImageResponse();
        response.setId(image.getId());
        response.setUrl(image.getUrl());

        return response;
    }

}
