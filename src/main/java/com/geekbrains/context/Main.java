package com.geekbrains.context;

import com.geekbrains.context.configuration.ApplicationConfiguration;
import com.geekbrains.context.domain.Cart;
import com.geekbrains.context.domain.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        Cart cart = context.getBean("cart", Cart.class);
        cart.addProductToCart(3);
        cart.addProductToCart(1);
        for (Product product : cart.getProductsInCart()) {
            System.out.printf("ID: %s | Title: %s, Price: %s", product.getId(), product.getTitle(), product.getCost());
        }
        Cart nextCart = context.getBean("cart", Cart.class);
        System.out.println(" ");
        nextCart.addProductToCart(4);
        for (Product product : nextCart.getProductsInCart()) {
            System.out.printf("ID: %s | Title: %s, Price: %s", product.getId(), product.getTitle(), product.getCost());
        }
    }
}
