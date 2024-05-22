package com.erayerm.ecommercebackend.repository;

import com.erayerm.ecommercebackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
