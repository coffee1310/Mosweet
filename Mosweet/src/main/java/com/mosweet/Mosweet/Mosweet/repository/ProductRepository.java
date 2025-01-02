package com.mosweet.Mosweet.Mosweet.repository;

import com.mosweet.Mosweet.Mosweet.entity.ProductRedis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<ProductRedis, Long> {
}

