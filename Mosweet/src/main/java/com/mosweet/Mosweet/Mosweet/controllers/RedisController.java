package com.mosweet.Mosweet.Mosweet.controllers;


import com.mosweet.Mosweet.Mosweet.entity.ProductRedis;
import com.mosweet.Mosweet.Mosweet.service.ProductServiceRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RedisController {
    @Autowired
    private ProductServiceRedis productService;

    @PostMapping
    public ResponseEntity<ProductRedis> save(@RequestBody ProductRedis product) {
        return new ResponseEntity<>(productService.save(product), HttpStatusCode.valueOf(201));
    }

    @GetMapping
    public ResponseEntity<ProductRedis> getById(@RequestParam Long id) {
        ProductRedis product = productService.getById(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(400));
        }
        return new ResponseEntity<>(product, HttpStatusCode.valueOf(200));
    }
}
