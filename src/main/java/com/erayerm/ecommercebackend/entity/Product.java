package com.erayerm.ecommercebackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "product", schema = "ecommerce")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 2, max = 40)
    private String name;
    private String description;
    @NotNull
    @DecimalMin(value = "0.01", message = "Fiyat 0'dan yüksek olmalı.")
    private Double price;
    @NotNull
    @Min(value = 0)
    private Integer stock;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @DecimalMin(value = "0.0")
    @DecimalMax(value = "5.0")
    private Double rating;
    @Column(name = "sell_count")
    @Min(value = 0)
    private Integer sellCount;

    @OneToMany(mappedBy = "product", cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    private List<Image> image;
}
