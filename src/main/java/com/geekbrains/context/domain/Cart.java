package com.geekbrains.context.domain;

import com.geekbrains.context.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    List<Product> productsInCart;
    ProductRepository rep;


    @Autowired
    public Cart(ProductRepository productRepository) {
        this.productsInCart = new ArrayList<>();
        this.rep = productRepository;
    }

    public void addProductToCart(int id) {
        productsInCart.add(rep.getProductById(id));
    }

    public void deleteProductFromCart(int id) {
        productsInCart.remove(rep.getProductById(id));
    }

    public List<Product> getProductsInCart() {
        return productsInCart;
    }
}
