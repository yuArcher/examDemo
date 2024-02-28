package com.example.demo.services.Impl;

import com.example.demo.entity.AppleEntity;
import com.example.demo.services.AppleService;
import org.springframework.stereotype.Service;

@Service
public class AppleServiceImp implements AppleService {
    /**
     * 计算苹果价格
     * @param appleEntity
     * @return
     */
    @Override
    public double totalMoney(AppleEntity appleEntity) {
        return appleEntity.getWeight()*appleEntity.getPrice();
    }
}
