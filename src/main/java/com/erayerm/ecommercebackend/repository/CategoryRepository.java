package com.erayerm.ecommercebackend.repository;

import com.erayerm.ecommercebackend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
