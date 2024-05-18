package com.erayerm.ecommercebackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "role", schema = "ecommerce")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;
}

/*
     Data Format

     Customer & Admin: { name, email, password, role_id }
     Store: { name, email, password, role_id, store: { name, phone, tax_no, bank_account } }
     NOTE! If you add an extra field, or change name of the field or there would be a missing field you can get an ERR from backend.
 */