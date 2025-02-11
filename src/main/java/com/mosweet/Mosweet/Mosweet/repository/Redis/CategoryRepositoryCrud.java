package com.mosweet.Mosweet.Mosweet.repository.Redis;

import com.mosweet.Mosweet.Mosweet.entity.PostgreSQL.Category;
import com.mosweet.Mosweet.Mosweet.entity.Redis.CategoryRedis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepositoryCrud extends CrudRepository<CategoryRedis, Long> {
}
