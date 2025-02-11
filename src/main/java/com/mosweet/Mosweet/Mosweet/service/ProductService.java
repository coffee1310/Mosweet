package com.mosweet.Mosweet.Mosweet.service;

import com.mosweet.Mosweet.Mosweet.entity.PostgreSQL.Product;
import com.mosweet.Mosweet.Mosweet.repository.PostgreSQL.ProductRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepositoryJpa productRepo;

    public List<Product> getProductsBySlug(String slug) {
        return productRepo.getProductByCategory_Slug(slug);
    }

    public Product getProductByArticle_number(int ArticleNumber) {
        return productRepo.getProductByArticleNumber(ArticleNumber);
    }
}
