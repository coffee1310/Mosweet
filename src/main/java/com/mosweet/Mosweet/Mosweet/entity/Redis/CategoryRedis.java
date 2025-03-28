package com.mosweet.Mosweet.Mosweet.entity.Redis;

import com.mosweet.Mosweet.Mosweet.entity.PostgreSQL.Category;
import com.mosweet.Mosweet.Mosweet.entity.PostgreSQL.Product;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.util.Set;

@Data
@RedisHash("categories")
public class CategoryRedis {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category", length = 64,nullable = false)
    private String category;

    @Column(name = "slug", length = 64, nullable = false)
    private String slug;

    @Column(name = "image_path", columnDefinition = "TEXT")
    private String image_path;

    public CategoryRedis() {}

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void fromCategoryToCategoryRedis(Category category) {
        this.id = category.getId();
        this.category = category.getCategory();
        this.slug = category.getSlug();
        this.image_path = category.getImagePath();
    }
}
