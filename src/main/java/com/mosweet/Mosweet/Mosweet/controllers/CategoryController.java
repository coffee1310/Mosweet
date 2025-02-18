package com.mosweet.Mosweet.Mosweet.controllers;

import com.mosweet.Mosweet.Mosweet.entity.PostgreSQL.Category;
import com.mosweet.Mosweet.Mosweet.repository.PostgreSQL.CategoryRepositoryJpa;
import com.mosweet.Mosweet.Mosweet.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping("/addCategory")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        categoryService.save(category);
        return new ResponseEntity<>(category, HttpStatus.valueOf(201));
    }

    @GetMapping("/getCategory/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable Long id) {
        Category category = categoryService.getCategoryById(id);
        if (category == null) {
            return new ResponseEntity<>(category, HttpStatus.valueOf(400));
        }
        return new ResponseEntity<>(category, HttpStatus.valueOf(200));
    }
}
