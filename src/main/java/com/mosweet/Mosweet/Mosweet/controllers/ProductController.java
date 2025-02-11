package com.mosweet.Mosweet.Mosweet.controllers;

import com.mosweet.Mosweet.Mosweet.entity.PostgreSQL.Product;
import com.mosweet.Mosweet.Mosweet.repository.PostgreSQL.ProductRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    ProductRepositoryJpa productRepo;

    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productRepo.save(product), HttpStatusCode.valueOf(201));
    }

    @GetMapping("/getProduct")
    public ResponseEntity<Product> getProduct(@RequestParam Long id) {
        Optional<Product> product = productRepo.findById(id);
        if (product.isPresent()) {
            return new ResponseEntity<>(product.get(), HttpStatusCode.valueOf(200));
        } else {
            return new ResponseEntity<>(HttpStatusCode.valueOf(400));
        }
    }
}
