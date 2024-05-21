package com.erayerm.ecommercebackend.service;

import com.erayerm.ecommercebackend.converter.CategoryConverter;
import com.erayerm.ecommercebackend.dto.CategoryRequest;
import com.erayerm.ecommercebackend.dto.CategoryResponse;
import com.erayerm.ecommercebackend.entity.Category;
import com.erayerm.ecommercebackend.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService{
    private CategoryRepository categoryRepository;
    private final CategoryConverter categoryConverter;
    public Category saveCategory(CategoryRequest categoryRequest){
        Category category = categoryConverter.convertRequestToEntity(categoryRequest);
        return categoryRepository.save(category);
    }
    public List<CategoryResponse> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        if (categories.isEmpty()) {
            //throw
        }
        return categories.stream().map(categoryConverter::convertToResponse).collect(Collectors.toList());
    }
}
