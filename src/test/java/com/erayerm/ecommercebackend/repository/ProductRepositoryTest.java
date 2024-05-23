package com.erayerm.ecommercebackend.repository;

import com.erayerm.ecommercebackend.entity.Category;
import com.erayerm.ecommercebackend.entity.Product;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    Category category;
    @BeforeEach
    void setUp() {
        category = new Category();
        category.setCode("category-code");
        category.setTitle("category-title");
        category.setImg("category-image.jpg");
        category.setRating(4.5);
        category.setGender("category-gender");

        categoryRepository.save(category);

        Product product1 = new Product();
        product1.setName("product-name-1");
        product1.setDescription("product-description-1");
        product1.setPrice(2.0);
        product1.setStock(1);
        product1.setCategory(category);
        product1.setRating(1.0);
        product1.setSellCount(1);

        Product product2 = new Product();
        product2.setName("product-name-2");
        product2.setDescription("product-description-2");
        product2.setPrice(1.0);
        product2.setStock(1);
        product2.setCategory(category);
        product2.setRating(2.0);
        product2.setSellCount(1);

        productRepository.save(product1);
        productRepository.save(product2);
    }

    @Test
    void testFindProductsByFilters_withCategoryFilter() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<Product> products = productRepository.findProductsByFilters(category.getId(), null, null, pageable);
        System.out.println(products.getTotalElements());
        assertEquals(2, products.getTotalElements());
    }

    @Test
    void testFindProductsByFilters_withNameFilter() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<Product> products = productRepository.findProductsByFilters(null, "product-name-1", null, pageable);

        assertEquals(1, products.getTotalElements());
        assertEquals("product-name-1", products.getContent().get(0).getName());
    }

    @Test
    void testFindProductsByFilters_withSortByPriceAsc() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<Product> products = productRepository.findProductsByFilters(null, null, "price:asc", pageable);

        List<Product> productList = products.getContent();
        assertTrue(productList.get(0).getPrice() <= productList.get(1).getPrice());
    }

    @Test
    void testFindProductsByFilters_withSortByRatingDesc() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<Product> products = productRepository.findProductsByFilters(null, null, "rating:desc", pageable);

        List<Product> productList = products.getContent();
        assertTrue(productList.get(0).getRating() >= productList.get(1).getRating());
    }
}