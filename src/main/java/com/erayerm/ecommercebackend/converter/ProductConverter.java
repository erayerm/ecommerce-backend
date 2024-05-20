package com.erayerm.ecommercebackend.converter;

import com.erayerm.ecommercebackend.dto.ProductResponse;
import com.erayerm.ecommercebackend.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public ProductResponse convertEntityToDto(Product product) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setName(product.getName());
        productResponse.setPrice(product.getPrice());
        return productResponse;
    }

    public Product convertDtoToEntity(ProductResponse productResponse) {
        Product product = new Product();
        product.setId(productResponse.getId());
        product.setName(productResponse.getName());
        product.setPrice(productResponse.getPrice());
        return product;
    }
}