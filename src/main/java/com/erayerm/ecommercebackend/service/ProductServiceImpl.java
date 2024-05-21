package com.erayerm.ecommercebackend.service;
import com.erayerm.ecommercebackend.converter.ProductConverter;
import com.erayerm.ecommercebackend.dto.*;
import com.erayerm.ecommercebackend.entity.Product;
import com.erayerm.ecommercebackend.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;
    private final ProductConverter productConverter;

    public List<Product> getProductsByFilters(Long category, String filter, String sort, Integer limit, Integer offset){
        Pageable pageable = PageRequest.of(offset, limit);
        return productRepository.findProductsByFilters(category, filter, sort, pageable).toList();
    }
    public Product saveProduct(ProductRequest productRequest) {
        Product product = productConverter.convertRequestToEntity(productRequest);
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
}
