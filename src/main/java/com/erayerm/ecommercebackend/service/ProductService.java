package com.erayerm.ecommercebackend.service;

import com.erayerm.ecommercebackend.dto.ProductDTO;
import com.erayerm.ecommercebackend.entity.Product;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ProductService {
    public List<Product> getProductsByFilters(Long category, String filter, String sort, Integer limit, Integer offset);
    public ProductDTO saveProduct(ProductDTO productDTO);
}
