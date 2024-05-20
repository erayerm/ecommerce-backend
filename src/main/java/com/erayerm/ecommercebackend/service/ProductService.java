package com.erayerm.ecommercebackend.service;

import com.erayerm.ecommercebackend.dto.ProductRequest;
import com.erayerm.ecommercebackend.dto.ProductResponse;
import com.erayerm.ecommercebackend.entity.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getProductsByFilters(Long category, String filter, String sort, Integer limit, Integer offset);
    public Product saveProduct(ProductRequest productRequest);
    public ProductResponse convertToResponse(Product product);
    public Product findProductById(Long productId);

    }
