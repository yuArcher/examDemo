package com.example.demo.entity;

import lombok.Data;

import javax.validation.constraints.Min;

/**
 * 苹果实体类
 */
@Data
public class AppleEntity {
    // 苹果价格
    private double price;

    // 苹果重量
    @Min(value = 0,message = "水果斤数为大于等于 0 的整数")
    private double weight;
}
