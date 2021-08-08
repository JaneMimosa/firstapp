package com.geekbrains.context.configuration;

import com.geekbrains.context.domain.Cart;
import com.geekbrains.context.repository.impl.ProductRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan({"com.geekbrains.context.repository", "com.geekbrains.context.service"})
public class ApplicationConfiguration {

    @Bean
    public ProductRepositoryImpl productRepository() {
        return new ProductRepositoryImpl();
    }

    @Bean
    @Scope("prototype")
    public Cart cart() {
        return new Cart(productRepository());
    }
}
