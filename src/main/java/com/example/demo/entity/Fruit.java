package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 水果实体类
 */
@Data
@AllArgsConstructor
public class Fruit {
    // 水果名称
    private String name;

    // 水果价格
    private double price;

    // 水果重量
    private double weight;
}
