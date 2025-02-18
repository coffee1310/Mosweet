package com.mosweet.Mosweet.Mosweet.service;

import com.mosweet.Mosweet.Mosweet.entity.PostgreSQL.Product;
import com.mosweet.Mosweet.Mosweet.repository.PostgreSQL.ProductRepositoryJpa;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductRepositoryJpa productRepo;

    public Iterable<Product> getProductsBySlug(String slug) {
        return productRepo.getProductByCategory_Slug(slug);
    }

    public Product getProductByArticle_number(int ArticleNumber) {return productRepo.getProductByArticleNumber(ArticleNumber);}

    public Product getProductById(Long id) {return productRepo.getProductById(id);}

    public Product save(Product product) {return productRepo.save(product);};
}