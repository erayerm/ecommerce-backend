package com.erayerm.ecommercebackend.service;

import com.erayerm.ecommercebackend.entity.Address;
import com.erayerm.ecommercebackend.repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class AddressServiceImpl implements AddressService{
    private AddressRepository addressRepository;
    public Address findById(Long id){
        Optional<Address> addressOptional=addressRepository.findById(id);
        if(addressOptional.isPresent()){
            return addressOptional.get();
        }
        //throw;
        return null;
    }
}
