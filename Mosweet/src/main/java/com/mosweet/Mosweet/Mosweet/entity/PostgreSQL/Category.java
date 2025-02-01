package com.mosweet.Mosweet.Mosweet.entity.PostgreSQL;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category", length = 64,nullable = false)
    private String category;

    @Column(name = "slug", length = 64, nullable = false)
    private String slug;

    @Column(name = "image_path", columnDefinition = "TEXT")
    private String image_path;

    @OneToMany(mappedBy = "category")
    private Set<Product> products;

    public Category() {}

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
