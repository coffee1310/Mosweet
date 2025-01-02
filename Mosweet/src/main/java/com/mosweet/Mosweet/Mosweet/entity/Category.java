package com.mosweet.Mosweet.Mosweet.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "Categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category", length = 64,nullable = false)
    private String category;

    @OneToMany(mappedBy = "category")
    private Set<Product> products;

    public Category(Long id) {}

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
