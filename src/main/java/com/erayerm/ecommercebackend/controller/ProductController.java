package com.erayerm.ecommercebackend.controller;

import com.erayerm.ecommercebackend.dto.ProductDTO;
import com.erayerm.ecommercebackend.entity.Product;
import com.erayerm.ecommercebackend.repository.ProductRepository;
import com.erayerm.ecommercebackend.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public ResponseEntity<List<ProductDTO>> getProductsByFilters(@RequestParam(required = false) Long category,
                                                                 @RequestParam(required = false) String filter,
                                                                 @RequestParam(required = false) String sort,
                                                                 @RequestParam(required = false, defaultValue = "25") Integer limit,
                                                                 @RequestParam(required = false, defaultValue = "0") Integer offset){
        List<ProductDTO> productDTOs = productService
                .getProductsByFilters(category, filter, sort, limit, offset)
                .stream().map(this::convertToDTO).toList();
        return ResponseEntity.ok().body(productDTOs);
    }

    @PostMapping("/")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        //Çalışmıyor henüz
        ProductDTO savedProductDTO = productService.saveProduct(productDTO);
        return ResponseEntity.ok(savedProductDTO);
    }



    public ProductDTO convertToDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setStock(product.getStock());
        dto.setCategoryId(product.getCategory().getId());
        dto.setCategoryCode(product.getCategory().getCode());
        dto.setRating(product.getRating());
        dto.setSellCount(product.getSellCount());
        dto.setImage(product.getImage());
        return dto;
    }

}
