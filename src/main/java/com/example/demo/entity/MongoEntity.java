package com.example.demo.entity;

import lombok.Data;

import javax.validation.constraints.Min;

/**
 * 芒果实体类
 */
@Data
public class MongoEntity {
    // 芒果价格
    private double price;

    // 芒果重量
    @Min(value = 0,message = "水果斤数为大于等于 0 的整数")
    private double weight;
}
