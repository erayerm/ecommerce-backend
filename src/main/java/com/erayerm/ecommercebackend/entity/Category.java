package com.erayerm.ecommercebackend.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/*
    {
        "id": 1,
        "code": "k:tisort",
        "title": "Tişört",
        "img": "https://workintech-fe-ecommerce.onrender.com/assets/category-img/category_kadın_tişört.jpg",
        "rating": 4.2,
        "gender": "k"
    }
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "category", schema = "ecommerce")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String title;
    private String img;
    private Double rating;
    private String gender;

    @OneToMany(mappedBy = "category", cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    private List<Product> products;
}
