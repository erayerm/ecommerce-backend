package com.erayerm.ecommercebackend.service;
import com.erayerm.ecommercebackend.converter.ProductConverter;
import com.erayerm.ecommercebackend.entity.Product;
import com.erayerm.ecommercebackend.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.erayerm.ecommercebackend.dto.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;
    private ProductConverter productConverter;

    public List<Product> getProductsByFilters(Long category, String filter, String sort, Integer limit, Integer offset){
        Pageable pageable = PageRequest.of(offset, limit);
        return productRepository.findProductsByFilters(category, filter, sort, pageable).toList();
    }

    public ProductDTO saveProduct(ProductDTO productDTO) {
        Product product = productConverter.convertDtoToEntity(productDTO);
        Product savedProduct = productRepository.save(product);
        return productConverter.convertEntityToDto(savedProduct);
    }
}
