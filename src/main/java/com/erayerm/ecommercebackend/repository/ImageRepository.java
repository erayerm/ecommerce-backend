package com.erayerm.ecommercebackend.repository;

import com.erayerm.ecommercebackend.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findByProductId(Long userId);
}