package com.example.demo.services;

import com.example.demo.entity.MongoEntity;

public interface MongoService {
    /**
     * 计算芒果价格
     * @param mongoEntity
     * @return
     */
    double totalMoney(MongoEntity mongoEntity);
}
