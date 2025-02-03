package com.mosweet.Mosweet.Mosweet.repository.Redis;

import com.mosweet.Mosweet.Mosweet.entity.PostgreSQL.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositoryCrud extends CrudRepository<Product, Long> {
}
