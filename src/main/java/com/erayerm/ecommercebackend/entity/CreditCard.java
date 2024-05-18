package com.erayerm.ecommercebackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "credit_card", schema = "ecommerce")
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String no;
    @Column(name = "name_on_card")
    private String nameOnCard;
    @Column(name = "expire_month")
    private String expireMonth;
    @Column(name = "expire_year")
    private String expireYear;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
