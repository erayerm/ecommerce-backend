package com.erayerm.ecommercebackend.controller;

import com.erayerm.ecommercebackend.converter.CategoryConverter;
import com.erayerm.ecommercebackend.converter.ImageConverter;
import com.erayerm.ecommercebackend.dto.CategoryRequest;
import com.erayerm.ecommercebackend.dto.CategoryResponse;
import com.erayerm.ecommercebackend.dto.ImageRequest;
import com.erayerm.ecommercebackend.dto.ImageResponse;
import com.erayerm.ecommercebackend.entity.Category;
import com.erayerm.ecommercebackend.entity.Image;
import com.erayerm.ecommercebackend.service.CategoryService;
import com.erayerm.ecommercebackend.service.ImageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    private final CategoryConverter categoryConverter;

    @GetMapping("/")
    public List<CategoryResponse> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public CategoryResponse getCategoryById(@PathVariable Long id){
        return categoryConverter.convertToResponse(categoryService.findById(id));
    }

    @PostMapping("/")
    public CategoryResponse createCategory(@RequestBody CategoryRequest categoryRequest) {
        Category category = categoryService.saveCategory(categoryRequest);
        return categoryConverter.convertToResponse(category);
    }
}
