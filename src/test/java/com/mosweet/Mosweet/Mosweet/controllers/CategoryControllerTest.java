package com.mosweet.Mosweet.Mosweet.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mosweet.Mosweet.Mosweet.entity.PostgreSQL.Category;
import com.mosweet.Mosweet.Mosweet.service.CategoryService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.event.annotation.AfterTestMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@EnableTransactionManagement
@Transactional
class CategoryControllerTest {
    @Autowired
    MockMvc mvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    CategoryService categoryService;

    Category category;

    List<Category> categories = new ArrayList<>();

    @Test
    public void addCategory() throws Exception {
        category = new Category();
        category.setCategory("Category");
        category.setSlug("CategorySlug");
        category.setImage_path("path");

        String categoryJson = objectMapper.writeValueAsString(category);
        mvc.perform(MockMvcRequestBuilders.post("/addCategory")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(categoryJson))
                .andExpect(status().isCreated());

        categories.add(category);
    }

    @Test
    public void getCategory() throws Exception {
        category = new Category();
        category.setId(1L);
        category.setCategory("Category");
        category.setSlug("CategorySlug");
        category.setImage_path("path");
        when(categoryService.getCategoryById(1L)).thenReturn(category);
        mvc.perform(MockMvcRequestBuilders.get("/getCategory/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.slug").value("CategorySlug"))
                .andExpect(jsonPath("$.image_path").value("path"));
        verify(categoryService, times(1)).getCategoryById(1L);
    }

    @AfterEach
    public void cleanUp() {
        for (Category category : categories) {
            categoryService.deleteCategoryBySlug(category.getSlug());
        }
        categories.clear();
    }

}