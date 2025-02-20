package com.mosweet.Mosweet.Mosweet.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mosweet.Mosweet.Mosweet.MosweetApplication;
import com.mosweet.Mosweet.Mosweet.entity.PostgreSQL.Category;
import com.mosweet.Mosweet.Mosweet.entity.PostgreSQL.Product;
import com.mosweet.Mosweet.Mosweet.entity.Redis.CategoryRedis;
import com.mosweet.Mosweet.Mosweet.entity.Redis.ProductRedis;
import com.mosweet.Mosweet.Mosweet.service.CategoryService;
import com.mosweet.Mosweet.Mosweet.service.ProductService;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.hamcrest.Matchers;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import reactor.core.publisher.Mono;
import redis.embedded.RedisServer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@Transactional
@EnableTransactionManagement
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

    @Autowired
    private ObjectMapper objectMapper;

    private static RedisServer redisServer;

    @Test
    void mainPageTest() throws Exception {
        this.mvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Mosweet")));
    }

    @Test
    void categoryPageTest() throws Exception {
        Category category = new Category();
        category.setSlug("categorySlug");
        category.setCategory("puncakes");
        category.setImagePath("path");

        CategoryRedis categoryRedis = new CategoryRedis();
        categoryRedis.fromCategoryToCategoryRedis(category);
        List<CategoryRedis> categoriesRedis = new ArrayList<>();
        categoriesRedis.add(categoryRedis);

        categoryService.save(category);
        categoryService.saveRedis(categoryRedis);
        System.out.println(categoryRedis.getCategory());
        this.mvc.perform(get("/category"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("category"))
                .andExpect(model().attributeExists("categories"))
                .andExpect(model().attribute("categories", categoriesRedis));
    }

    @Test
    void categoryDetail() throws Exception {
        Category category = new Category();
        category.setSlug("categorySlug");
        category.setCategory("puncakes");
        category.setImagePath("path");

        Product product = new Product();
        product.setTitle("title");
        product.setDescription("description");
        product.setCategory(category);
        product.setPrice(100);
        product.setArticleNumber(1);
        product.setKcal(100);
        product.setWeight(100);
        product.setCompound("Compound");
        product.setImagePath("image_path");

        categoryService.save(category);
        productService.save(product);

        List<Product> products = new ArrayList<>();
        products.add(product);
        this.mvc.perform(get("/category/{slug}", category.getSlug()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("products"))
                .andExpect(model().attributeExists("products"))
                .andExpect(model().attributeExists("category"))
                .andExpect(model().attribute("products", products));
    }

    @Test
    void productPage() throws Exception {
        Category category = new Category();
        category.setSlug("categorySlug");
        category.setCategory("puncakes");
        category.setImagePath("path");

        Product product = new Product();
        product.setTitle("title");
        product.setDescription("description");
        product.setCategory(category);
        product.setPrice(100);
        product.setArticleNumber(2);
        product.setKcal(100);
        product.setWeight(100);
        product.setCompound("Compound");
        product.setImagePath("image_path");

        categoryService.save(category);
        productService.save(product);

        this.mvc.perform(get("/products/{article_number}", product.getArticleNumber()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("product"))
                .andExpect(model().attribute("product", product));
    }

    @Test
    void prodcutsPage() {

    }

    @BeforeAll
    static void startRedis() throws Exception {
        redisServer = new RedisServer(6379);
        redisServer.start();
    }

    @AfterAll
    static void stopRedis() {
        redisServer.stop();
    }
}