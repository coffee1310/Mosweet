package com.mosweet.Mosweet.Mosweet.controllers;

import com.mosweet.Mosweet.Mosweet.entity.PostgreSQL.Category;
import com.mosweet.Mosweet.Mosweet.repository.PostgreSQL.CategoryRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {
    @Autowired
    CategoryRepositoryJpa categoryRepo;

    @PostMapping("/addCategory")
    public void addCategory(@RequestBody Category category) {
        categoryRepo.save(category);
    }

    @GetMapping("/getCategory")
    public ResponseEntity<Category> getCategory(@RequestParam Long id) {
        Category category = categoryRepo.findById(id).get();
        if (category == null) {
            return new ResponseEntity<>(category, HttpStatus.valueOf(400));
        }
        return new ResponseEntity<>(category, HttpStatus.valueOf(201));
    }
}
