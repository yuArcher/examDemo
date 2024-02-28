package com.example.demo.services.Impl;

import com.example.demo.entity.StrawberryEntity;
import com.example.demo.services.StrawberryService;
import org.springframework.stereotype.Service;

@Service
public class StrawberryServiceImp implements StrawberryService {

    /**
     * 计算草莓价格
     * @param strawberryEntity
     * @return
     */
    @Override
    public double totalMoney(StrawberryEntity strawberryEntity) {
        return strawberryEntity.getWeight()*strawberryEntity.getPrice();
    }
}
