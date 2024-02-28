package com.example.demo.services;

import com.example.demo.entity.AppleEntity;

public interface AppleService {
    /**
     * 计算苹果价格
     * @param appleEntity
     * @return
     */
    double totalMoney(AppleEntity appleEntity);
}
