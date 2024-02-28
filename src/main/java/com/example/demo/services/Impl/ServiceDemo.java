package com.example.demo.services.Impl;

import com.example.demo.entity.AppleEntity;
import com.example.demo.entity.MongoEntity;
import com.example.demo.entity.StrawberryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServiceDemo {
    @Autowired
    AppleServiceImp appleServiceImp;

    @Autowired
    StrawberryServiceImp strawberryServiceImp;

    @Autowired
    MongoServiceImp mongoServiceImp;


    /**
     * 计算苹果和草莓总价格
     * @param appleEntity
     * @param strawberryEntity
     * @return
     */
    public double total(AppleEntity appleEntity,StrawberryEntity strawberryEntity) {
        double appleTotal = appleServiceImp.totalMoney(appleEntity);
        double strawberryTotal = strawberryServiceImp.totalMoney(strawberryEntity);

        return appleTotal+strawberryTotal;
    }

    /**
     * 计算苹果、草莓、芒果总价格
     * @param appleEntity
     * @param strawberryEntity
     * @param mongoEntity
     * @return
     */
    public double total(AppleEntity appleEntity,StrawberryEntity strawberryEntity,MongoEntity mongoEntity) {
        double appleTotal = appleServiceImp.totalMoney(appleEntity);
        double strawberryTotal = strawberryServiceImp.totalMoney(strawberryEntity);
        double mongoTotal = mongoServiceImp.totalMoney(mongoEntity);

        return appleTotal+strawberryTotal+mongoTotal;
    }
}
