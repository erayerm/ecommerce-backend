package com.erayerm.ecommercebackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/*
        {
            "id": 2,
            "name": "Siyah %100 Pamuk",
            "description": "Siyah %100 Pamuk Regular/Normal Kalıp Basic V Yaka Uzun Kollu Örme T-Shirt TWOAW21TS0099",
            "price": 145.99,
            "stock": 84,
            "store_id": 1,
            "category_id": 1,
            "rating": 0.35,
            "sell_count": 923,
            "images": [
                {
                    "url": "https://cdn.dsmcdn.com/ty155/product/media/images/20210806/13/116221695/81629339/1/1_org_zoom.jpg",
                    "index": 0
                }
            ]
        }
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "product", schema = "ecommerce")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer stock;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private Double rating;
    @Column(name = "sell_count")
    private Integer sellCount;

    @OneToMany(mappedBy = "product", cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    private Set<Image> image;
}
