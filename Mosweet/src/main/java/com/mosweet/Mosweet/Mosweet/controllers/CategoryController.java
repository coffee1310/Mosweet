package com.mosweet.Mosweet.Mosweet.controllers;

import com.mosweet.Mosweet.Mosweet.entity.Category;
import com.mosweet.Mosweet.Mosweet.repository.JpaCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
    @Autowired
    JpaCategoryRepository categoryRepo;

    @PostMapping("/addCategory")
    public void addCategory(@RequestBody Category category) {
        categoryRepo.save(category);
    }
}
