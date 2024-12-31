package com.mosweet.Mosweet.Mosweet.entity;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@RedisHash("Product")
public class Product implements Serializable {
    private int id;
    private String title;
}
