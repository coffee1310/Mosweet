package com.mosweet.Mosweet.Mosweet.service;

import com.mosweet.Mosweet.Mosweet.entity.PostgreSQL.Category;
import com.mosweet.Mosweet.Mosweet.entity.Redis.CategoryRedis;
import com.mosweet.Mosweet.Mosweet.repository.PostgreSQL.CategoryRepositoryJpa;
import com.mosweet.Mosweet.Mosweet.repository.Redis.CategoryRepositoryCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepositoryJpa categoryRepo;
    @Autowired
    CategoryRepositoryCrud categoryRepoCrud;

    public Category getCategoryBySlug(String slug) {
        return categoryRepo.getCategoryBySlug(slug);
    }

    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    public CategoryRedis saveRedis(CategoryRedis category) {
        return this.categoryRepoCrud.save(category);
    }

    public CategoryRedis getByIdRedis(Long id) {
        return categoryRepoCrud.findById(id).orElse(null);
    }

    @Cacheable(value = "categories")
    public Iterable<CategoryRedis> findAllRedis() {
        return categoryRepoCrud.findAll();
    }

    public int getCountRedis() {
        return Math.toIntExact(categoryRepoCrud.count());
    }


}
