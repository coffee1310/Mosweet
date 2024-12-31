package com.mosweet.Mosweet.Mosweet.controllers;

import com.mosweet.Mosweet.Mosweet.entity.Product;
import com.mosweet.Mosweet.Mosweet.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MainController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product) {
        return new ResponseEntity<>(productService.save(product), HttpStatusCode.valueOf(201));
    }

    @GetMapping
    public ResponseEntity<Product> getById(@RequestParam Integer id) {
        Product product = productService.getById(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(400));
        }
        return new ResponseEntity<>(product, HttpStatusCode.valueOf(200));
    }
}
