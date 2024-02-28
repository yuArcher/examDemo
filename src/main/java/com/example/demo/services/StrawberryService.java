package com.example.demo.services;

import com.example.demo.entity.StrawberryEntity;

public interface StrawberryService {
    /**
     * 计算草莓价格
     * @param strawberryEntity
     * @return
     */
    double totalMoney(StrawberryEntity strawberryEntity);
}
