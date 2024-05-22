package com.erayerm.ecommercebackend.repository;

import com.erayerm.ecommercebackend.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
