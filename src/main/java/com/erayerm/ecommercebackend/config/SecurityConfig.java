package com.workintech.springauthenticationauthorization.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.lang.reflect.Array;
import java.util.Arrays;

//csrf => Cross Site resource forgery

//Authentication(Sisteme Login olmak, Giriş yapma) ve Authorization(Yetkilendirme-Rol based)

//STEP1: pom.xml security dependency eklenmeli
//STEP2: Veritabanı üzerinde user ve role tanımlanıp ilgili entityler oluşturulmalı
//STEP3: Security Config üzerinde SecurityFilterChain, passwordEncoder, authManager 3 ünün tanımlanması
//STEP4: UserRepository ve RoleRepository tanımla. İhtiyaç duyduğun metodları yaz.
//UserService with loadUserByUsername method(login)
//STEP5: AuthenticationService de register methodunu tanımlamak
//STEP6: SecurityFilterChain'i register a açmak
//STEP7: Endpointleri yazmak(/auht/register)

@Configuration
public class SecurityConfig {
    @Bean
    public AuthenticationManager authManager(UserDetailsService userDetailsService){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return new ProviderManager(provider);
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/auth/**").permitAll();
                    auth.anyRequest().authenticated();
                })
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .build();
    }


}