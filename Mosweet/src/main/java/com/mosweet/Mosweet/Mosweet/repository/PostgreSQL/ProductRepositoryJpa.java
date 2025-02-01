package com.mosweet.Mosweet.Mosweet.repository.PostgreSQL;

import com.mosweet.Mosweet.Mosweet.entity.PostgreSQL.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepositoryJpa extends JpaRepository<Product, Long> {
    List<Product> getProductByCategory_Slug(String slug);
    Product getProductByArticleNumber(int ArticleNumber);
}
