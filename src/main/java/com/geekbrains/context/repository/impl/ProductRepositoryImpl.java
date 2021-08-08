package com.geekbrains.context.repository.impl;

import com.geekbrains.context.domain.Product;
import com.geekbrains.context.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    Random rand = new Random();
    List<Product> productsList;

    public ProductRepositoryImpl() {
        List<Product> productsList = new ArrayList<>();
        int cost;
        for (int i = 0; i < 5; i++) {
            cost = rand.nextInt(10000);
            productsList.add(new Product(i, "Product", cost));
        }
        this.productsList = productsList;
    }

    @Override
    public List<Product> getProducts() {
        return productsList;
    }

    public Product getProductById(int id) {
        for (Product product : productsList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
