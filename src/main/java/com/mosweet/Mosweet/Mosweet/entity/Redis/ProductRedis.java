package com.mosweet.Mosweet.Mosweet.entity.Redis;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mosweet.Mosweet.Mosweet.entity.PostgreSQL.Category;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

@Data
@RedisHash("products")
public class ProductRedis {
    @Id
    private Long id;

    @Column(name = "title", nullable = false, length = 64)
    private String title;
    private String description;

    private int price;
    private int article_number;
    private int kcal;
    private int weight;
    private String compound;
    private String image_path;


    public ProductRedis() {}

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
