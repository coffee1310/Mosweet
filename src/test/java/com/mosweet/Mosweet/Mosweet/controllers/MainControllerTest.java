package com.mosweet.Mosweet.Mosweet.controllers;

import com.mosweet.Mosweet.Mosweet.MosweetApplication;
import com.mosweet.Mosweet.Mosweet.entity.PostgreSQL.Category;
import com.mosweet.Mosweet.Mosweet.entity.PostgreSQL.Product;
import com.mosweet.Mosweet.Mosweet.entity.Redis.CategoryRedis;
import com.mosweet.Mosweet.Mosweet.service.CategoryService;
import com.mosweet.Mosweet.Mosweet.service.ProductService;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.hamcrest.Matchers;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Collection;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@Transactional
@SpringBootTest(classes = MosweetApplication.class)
class MainControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    EntityManager entityManager;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Test
    void mainPageTest() throws Exception {
        this.mvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Mosweet")));
    }

    @Test
    void categoryPageTest() throws Exception {
        Iterable<CategoryRedis> categories = categoryService.findAllRedis();

        this.mvc.perform(get("/category"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("category"))
                .andExpect(model().attributeExists("categories"))
                .andExpect(model().attribute("categories", categories));
    }

    @Test
    void categoryDetail() throws Exception {
        String categorySlug = "puncakes";

        this.mvc.perform(get("/category/" + categorySlug))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("products"))
                .andExpect(model().attributeExists("products"))
                .andExpect(model().attributeExists("category"))
                .andExpect(model().attribute("products", Matchers.not(Matchers.empty())));
    }

    @Test
    void productPage() {

    }

    @Test
    void prodcutsPage() {
    }
}