package com.erayerm.ecommercebackend.service;
import com.erayerm.ecommercebackend.dto.CategoryResponse;
import com.erayerm.ecommercebackend.dto.ProductRequest;
import com.erayerm.ecommercebackend.entity.Category;
import com.erayerm.ecommercebackend.entity.Product;
import com.erayerm.ecommercebackend.repository.CategoryRepository;
import com.erayerm.ecommercebackend.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.erayerm.ecommercebackend.dto.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private ImageService imageService;

    public List<Product> getProductsByFilters(Long category, String filter, String sort, Integer limit, Integer offset){
        Pageable pageable = PageRequest.of(offset, limit);
        return productRepository.findProductsByFilters(category, filter, sort, pageable).toList();
    }

    public Product saveProduct(ProductRequest productRequest) {
        //Alttaki işlemi de convertToRequst olarak ayrı bir fonksiyonda yap
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        product.setStock(productRequest.getStock());
        product.setRating(productRequest.getRating());
        product.setSellCount(productRequest.getSellCount());

        Category category = categoryRepository.findById(productRequest.getCategoryId()).orElseThrow(() -> new RuntimeException("Category not found"));
        product.setCategory(category);

        return productRepository.save(product);
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

        // ImageResponse ekleme işlemleri de burada yapılabilir
        response.setImages(imageService.getImagesByProductId(product.getId()));
        return response;
    }
}
