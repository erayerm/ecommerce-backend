package com.erayerm.ecommercebackend.controller;

import com.erayerm.ecommercebackend.converter.AddressConverter;
import com.erayerm.ecommercebackend.dto.AddressResponse;
import com.erayerm.ecommercebackend.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/address")
public class AddressController {
    private AddressService addressService;
    private final AddressConverter addressConverter;

    @GetMapping("/{id}")
    public AddressResponse getAddressById(@PathVariable Long id){
        return addressConverter.convertToResponse(addressService.findById(id));
    }
}
