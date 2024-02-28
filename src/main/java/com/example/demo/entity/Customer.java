package com.example.demo.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 顾客实体类
 */
@Data
public class Customer {
    // 顾客名称
    private String name;

    // 顾客购买的所有水果
    private List<Fruit> fruitList = new ArrayList<>();

    // 顾客购买的水果
    public void buyFruit(Fruit fruit){
        fruitList.add(fruit);
    }
}
