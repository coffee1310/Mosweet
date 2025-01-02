package com.mosweet.Mosweet.Mosweet.repository;

import com.mosweet.Mosweet.Mosweet.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface JpaCategoryRepository extends JpaRepository<Category, Long> {
}
