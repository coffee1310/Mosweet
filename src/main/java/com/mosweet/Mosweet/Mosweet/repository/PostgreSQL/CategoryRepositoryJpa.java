package com.mosweet.Mosweet.Mosweet.repository.PostgreSQL;

import com.mosweet.Mosweet.Mosweet.entity.PostgreSQL.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepositoryJpa extends JpaRepository<Category, Long> {
    Category getCategoryBySlug(String slug);
    Category getCategoryById(Long id);
    Category deleteCategoryById(Long id);
    void deleteCategoryBySlug(String slug);
}
