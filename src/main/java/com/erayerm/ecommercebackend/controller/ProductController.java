package com.erayerm.ecommercebackend.controller;

import com.erayerm.ecommercebackend.converter.ProductConverter;
import com.erayerm.ecommercebackend.dto.ProductRequest;
import com.erayerm.ecommercebackend.dto.ProductResponse;
import com.erayerm.ecommercebackend.entity.Product;
import com.erayerm.ecommercebackend.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    private final ProductConverter productConverter;
    @GetMapping("/")
    public ResponseEntity<List<ProductResponse>> getProductsByFilters(@RequestParam(required = false) Long category,
                                                                      @RequestParam(required = false) String filter,
                                                                      @RequestParam(required = false) String sort,
                                                                      @RequestParam(required = false, defaultValue = "25") Integer limit,
                                                                      @RequestParam(required = false, defaultValue = "0") Integer offset){
        List<ProductResponse> productResponses = productService
                .getProductsByFilters(category, filter, sort, limit, offset)
                .stream().map(productConverter::convertToResponse).toList();
        return ResponseEntity.ok().body(productResponses);
    }

    @PostMapping("/")
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest) {
        Product product = productService.saveProduct(productRequest);
        return productConverter.convertToResponse(product);
    }


}
