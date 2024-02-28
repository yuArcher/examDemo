package com.example.demo.services.Impl;

import com.example.demo.entity.MongoEntity;
import com.example.demo.services.MongoService;
import org.springframework.stereotype.Service;

@Service
public class MongoServiceImp implements MongoService {
    /**
     * 计算芒果价格
     * @param mongoEntity
     * @return
     */
    @Override
    public double totalMoney(MongoEntity mongoEntity) {
        return mongoEntity.getWeight()*mongoEntity.getPrice();
    }
}
