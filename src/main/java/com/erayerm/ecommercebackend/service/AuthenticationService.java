package com.erayerm.ecommercebackend.service;

import com.erayerm.ecommercebackend.entity.Cart;
import com.erayerm.ecommercebackend.entity.user.Role;
import com.erayerm.ecommercebackend.entity.user.User;
import com.erayerm.ecommercebackend.repository.RoleRepository;
import com.erayerm.ecommercebackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthenticationService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthenticationService(UserRepository userRepository, RoleRepository roleRepository,
                                 PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(String fullName, String email, String password){
        String encodedPassword = passwordEncoder.encode(password);
        Role userRole = roleRepository.findByAuthority("USER").get();

        List<Role> roles = new ArrayList<>();
        roles.add(userRole);

        User user = new User();
        user.setPassword(encodedPassword);
        user.setName(fullName);
        user.setEmail(email);
        user.setAuthorities(roles);

        Cart cart = new Cart();
        cart.setUser(user);
        user.setCart(cart);

        return userRepository.save(user);
    }
}
