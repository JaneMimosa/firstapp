package com.geekbrains.context.service.impl;

import com.geekbrains.context.domain.Product;
import com.geekbrains.context.repository.ProductRepository;
import com.geekbrains.context.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.getProducts();
    }
}
