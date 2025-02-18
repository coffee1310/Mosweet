package com.mosweet.Mosweet.Mosweet.entity.PostgreSQL;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, length = 64)
    private String title;

    @Column(name = "description", length = 255)
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "article_number", nullable = false)
    private int articleNumber;

    @Column(name = "kcal", nullable = false)
    private int kcal;

    @Column(name = "weight", nullable = false)
    private int weight;

    @Column(name = "compound")
    private String compound;

    @Column(name = "image_path")
    private String imagePath;

    public Product() {}
}