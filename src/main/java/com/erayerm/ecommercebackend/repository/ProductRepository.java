package com.erayerm.ecommercebackend.repository;

import com.erayerm.ecommercebackend.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE (:filter IS NULL OR p.name LIKE %:filter% OR p.description LIKE %:filter%) " +
            "AND (:category IS NULL OR p.category.id = :category) " +
            "ORDER BY " +
            "CASE WHEN :sort = 'price:asc' THEN p.price END ASC, " +
            "CASE WHEN :sort = 'price:desc' THEN p.price END DESC, " +
            "CASE WHEN :sort = 'rating:asc' THEN p.rating END ASC, " +
            "CASE WHEN :sort = 'rating:desc' THEN p.rating END DESC" )
    Page<Product> findProductsByFilters(@Param("category") Long category,
                                        @Param("filter") String filter,
                                        @Param("sort") String sort,
                                        Pageable pageable);
}
