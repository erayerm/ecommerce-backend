package com.erayerm.ecommercebackend.service;

import com.erayerm.ecommercebackend.dto.CategoryRequest;
import com.erayerm.ecommercebackend.dto.CategoryResponse;
import com.erayerm.ecommercebackend.entity.Category;

import java.util.List;

public interface CategoryService {
    public Category saveCategory(CategoryRequest categoryRequest);
    public List<CategoryResponse> getAllCategories();
    public Category findById(Long id);

}
