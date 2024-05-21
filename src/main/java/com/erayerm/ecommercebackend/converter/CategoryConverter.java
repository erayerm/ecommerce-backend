package com.erayerm.ecommercebackend.converter;

import com.erayerm.ecommercebackend.dto.CategoryRequest;
import com.erayerm.ecommercebackend.dto.CategoryResponse;
import com.erayerm.ecommercebackend.entity.Category;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CategoryConverter {
    public CategoryResponse convertToResponse(Category category) {
        CategoryResponse response = new CategoryResponse();
        response.setId(category.getId());
        response.setCode(category.getCode());
        response.setTitle(category.getTitle());
        response.setImg(category.getImg());
        response.setRating(category.getRating());
        response.setGender(category.getGender());
        return response;
    }
    public Category convertRequestToEntity(CategoryRequest categoryRequest) {
        Category category = new Category();
        category.setCode(categoryRequest.getCode());
        category.setTitle(categoryRequest.getTitle());
        category.setImg(categoryRequest.getImg());
        category.setRating(categoryRequest.getRating());
        category.setGender(categoryRequest.getGender());
        return category;
    }

}
