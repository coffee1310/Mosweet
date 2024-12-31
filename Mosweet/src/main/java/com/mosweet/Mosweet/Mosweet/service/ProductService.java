package com.mosweet.Mosweet.Mosweet.service;

import com.mosweet.Mosweet.Mosweet.entity.Product;
import com.mosweet.Mosweet.Mosweet.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepo;

    @Autowired
    public ProductService(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    public Product save(Product product) {
        return productRepo.save(product);
    }

    @Cacheable(value = "products", key = "#id")
    public Product getById(Integer id) {
        return productRepo.findById(id).orElse(null);
    }
}
