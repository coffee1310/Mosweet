package com.mosweet.Mosweet.Mosweet.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class CategoryServiceTest {
    @Autowired
    MockMvc mvc;

    @Test
    void getCategoryBySlug() {
    }

    @Test
    void findAll() {
    }

    @Test
    void saveRedis() {
    }

    @Test
    void getByIdRedis() {
    }

    @Test
    void findAllRedis() {
    }

    @Test
    void getCountRedis() {
    }
}