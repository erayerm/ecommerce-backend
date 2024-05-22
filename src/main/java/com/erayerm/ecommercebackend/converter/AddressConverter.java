package com.erayerm.ecommercebackend.converter;

import com.erayerm.ecommercebackend.dto.AddressResponse;
import com.erayerm.ecommercebackend.entity.Address;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AddressConverter {
    public AddressResponse convertToResponse(Address address){
        //User'dan sonra tekrar düzenle
        AddressResponse addressResponse = new AddressResponse();
        return addressResponse;
    }
}
