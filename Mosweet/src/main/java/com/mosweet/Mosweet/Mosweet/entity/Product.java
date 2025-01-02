package com.mosweet.Mosweet.Mosweet.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "title", nullable = false, length = 64)
    private String title;
    private String description;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;
    private int price;
    private int article_number;
    private int Kcal;
    private int weight;
    private String compound;

    @Lob
    @Column(name = "image_data")
    private byte[] img;

    public Product() {}

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
