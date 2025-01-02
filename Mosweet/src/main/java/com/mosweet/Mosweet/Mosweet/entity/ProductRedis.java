package com.mosweet.Mosweet.Mosweet.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
@Data
@RedisHash("ProductRedis")
public class ProductRedis implements Serializable{
    private long id;
    @Column(name = "title", nullable = false, length = 64)
    private String title;
    private String description;
    private long category_id;
    private int price;
    private int article_number;
    private int Kcal;
    private int weight;
    private String compound;

    @Lob
    @Column(name = "image_data")
    private byte[] img;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}