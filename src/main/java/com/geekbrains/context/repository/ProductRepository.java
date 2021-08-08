package com.geekbrains.context.repository;

import com.geekbrains.context.domain.Product;

import java.util.ArrayList;
import java.util.List;

public interface ProductRepository {
    public List<Product> getProducts();
    public Product getProductById(int id);
}
