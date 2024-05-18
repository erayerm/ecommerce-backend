package com.erayerm.ecommercebackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.processing.Generated;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="cart_item", schema = "ecommerce")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer count;
    private Boolean checked;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
