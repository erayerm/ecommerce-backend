package com.erayerm.ecommercebackend.service;

import com.erayerm.ecommercebackend.entity.Address;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


public interface AddressService {
    public Address findById(Long id);
}
