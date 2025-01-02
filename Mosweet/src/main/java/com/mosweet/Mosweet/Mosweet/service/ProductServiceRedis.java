package com.mosweet.Mosweet.Mosweet.service;


import com.mosweet.Mosweet.Mosweet.entity.ProductRedis;
import com.mosweet.Mosweet.Mosweet.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceRedis {
    private final ProductRepository productRepo;

    @Autowired
    public ProductServiceRedis(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    public ProductRedis save(ProductRedis product) {
        return productRepo.save(product);
    }

    @Cacheable(value = "products", key = "#id")
    public ProductRedis getById(Long id) {
        return productRepo.findById(id).orElse(null);
    }
}
