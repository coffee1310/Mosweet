package com.mosweet.Mosweet.Mosweet.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mosweet.Mosweet.Mosweet.entity.PostgreSQL.Category;
import com.mosweet.Mosweet.Mosweet.entity.PostgreSQL.Product;
import com.mosweet.Mosweet.Mosweet.service.CategoryService;
import com.mosweet.Mosweet.Mosweet.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@EnableTransactionManagement
@Transactional
@SuppressWarnings("removal")
class ProductControllerTest {
    @MockBean
    ProductService productService;

    @MockBean
    CategoryService categoryService;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MockMvc mvc;

    Product product;

    List<Product> products = new ArrayList<>();

    @Test
    void addProductTest() throws Exception {
        product = new Product();
        Category category = new Category();

        category.setId(3L);
        category.setCategory("Category");
        category.setSlug("slug");
        category.setImagePath("path");

        product.setTitle("title");
        product.setDescription("description");
        product.setCategory(category);
        product.setPrice(100);
        product.setArticleNumber(1);
        product.setKcal(100);
        product.setWeight(100);
        product.setCompound("Compound");
        product.setImagePath("image_path");

        String productJson = objectMapper.writeValueAsString(product);
        System.out.println(productJson);

        when(productService.save(product)).thenReturn(product);

        mvc.perform(MockMvcRequestBuilders.post("/addProduct")
                .contentType(MediaType.APPLICATION_JSON)
                .content(productJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("title"))
                .andExpect(jsonPath("$.description").value("description"))
                .andExpect(jsonPath("$.imagePath").value("image_path"))
                .andExpect(jsonPath("$.price").value(100))
                .andExpect(jsonPath("$.category").value(product.getCategory()))
                .andExpect(jsonPath("$.articleNumber").value(1))
                .andExpect(jsonPath("$.kcal").value(100));
        verify(productService, times(1)).save(product);

        products.add(product);
    }

    @Test
    void getProductTest() throws Exception{
        product = new Product();
        Category category = new Category();

        category.setId(3L);
        category.setCategory("Category");
        category.setSlug("slug");
        category.setImagePath("path");

        product.setId(100L);
        product.setTitle("title");
        product.setDescription("description");
        product.setCategory(category);
        product.setPrice(100);
        product.setArticleNumber(1);
        product.setKcal(100);
        product.setWeight(100);
        product.setCompound("Compound");
        product.setImagePath("image_path");

        String productJson = objectMapper.writeValueAsString(product);
        System.out.println(productJson);

        when(productService.getProductById(product.getId())).thenReturn(product);

        mvc.perform(MockMvcRequestBuilders.get("/getProduct/{id}", product.getId()))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("title"))
                .andExpect(jsonPath("$.description").value("description"))
                .andExpect(jsonPath("$.imagePath").value("image_path"))
                .andExpect(jsonPath("$.price").value(100))
                .andExpect(jsonPath("$.category").value(product.getCategory()))
                .andExpect(jsonPath("$.articleNumber").value(1))
                .andExpect(jsonPath("$.kcal").value(100));
        verify(productService, times(1)).getProductById(product.getId());
    }
}