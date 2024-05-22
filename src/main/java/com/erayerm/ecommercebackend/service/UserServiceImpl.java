package com.erayerm.ecommercebackend.service;

import com.erayerm.ecommercebackend.dto.UserRequest;
import com.erayerm.ecommercebackend.entity.Cart;
import com.erayerm.ecommercebackend.entity.User;
import com.erayerm.ecommercebackend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User createUserWithCart(UserRequest userRequest){
        User user = new User();
        user.setEmail(userRequest.getEmail());
        user.setName(userRequest.getName());
        user.setPassword(userRequest.getPassword());
        //user.setRole(); burada Role'un findById'sini kullanıp eşleştirme yapmam lazım

        Cart cart = new Cart();
        cart.setUser(user);

        user.setCart(cart);
        return userRepository.save(user);
    }
    /*
    public User createUserWithCart(UserRequest userRequest){
        User user = new User();
        user.setPhone(userRequest.getPhone());
        user.setName(userRequest.getName());
        user.setTaxNo(userRequest.getTaxNo());
        user.setBankAccount(userRequest.getBankAccount());

        Cart cart = new Cart();
        cart.setUser(user);

        user.setCart(cart);
        System.out.println(userRequest);
        System.out.println("debug123");
        return userRepository.save(user);
    }

     */
}
