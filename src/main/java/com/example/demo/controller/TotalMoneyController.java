package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.entity.AppleEntity;
import com.example.demo.entity.MongoEntity;
import com.example.demo.entity.StrawberryEntity;
import com.example.demo.services.Impl.ServiceDemo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
public class TotalMoneyController {
    @Autowired
    ServiceDemo serviceDemo;


    /**
     * 计算苹果草莓总价
     * @param map
     * @return
     */
    @PostMapping("/api/getFirstTotalMoney")
    public Result<?> getFirstTotalMoney(@RequestBody Map<String, Double> map){
        AppleEntity appleEntity = new AppleEntity();
        appleEntity.setPrice(map.get("applePrice"));
        appleEntity.setWeight(map.get("appleWeight"));

        StrawberryEntity strawberryEntity = new StrawberryEntity();
        strawberryEntity.setPrice(map.get("strawBerryPrice"));
        strawberryEntity.setWeight(map.get("strawBerryWeight"));
        double total = serviceDemo.total(appleEntity, strawberryEntity);
        return Result.success(total);
    }

    /**
     * 计算苹果、草莓总、芒果总价
     * @param map
     * @return
     */
    @PostMapping("/api/getSecondThirdTotalMoney")
    public Result<?> getSecondThirdTotalMoney(@RequestBody Map<String, Double> map){
        AppleEntity appleEntity = new AppleEntity();
        appleEntity.setPrice(map.get("applePrice"));
        appleEntity.setWeight(map.get("appleWeight"));

        StrawberryEntity strawberryEntity = new StrawberryEntity();
        strawberryEntity.setPrice(map.get("strawBerryPrice"));
        strawberryEntity.setWeight(map.get("strawBerryWeight"));

        MongoEntity mongoEntity = new MongoEntity();
        mongoEntity.setPrice(map.get("mongoPrice"));
        mongoEntity.setWeight(map.get("mongoWeight"));

        double total = serviceDemo.total(appleEntity, strawberryEntity,mongoEntity);
        return Result.success(total);
    }

    /**
     * 计算苹果、草莓总、芒果总价
     * @param map
     * @return
     */
    @PostMapping("/api/getFourthTotalMoney")
    public Result<?> getFourthTotalMoney(@RequestBody Map<String, Double> map){
        AppleEntity appleEntity = new AppleEntity();
        appleEntity.setPrice(map.get("applePrice"));
        appleEntity.setWeight(map.get("appleWeight"));

        StrawberryEntity strawberryEntity = new StrawberryEntity();
        strawberryEntity.setPrice(map.get("strawBerryPrice"));
        strawberryEntity.setWeight(map.get("strawBerryWeight"));

        MongoEntity mongoEntity = new MongoEntity();
        mongoEntity.setPrice(map.get("mongoPrice"));
        mongoEntity.setWeight(map.get("mongoWeight"));

        double total = serviceDemo.total(appleEntity, strawberryEntity,mongoEntity);
        double totalD = 0;
        if (total % 100 < 92) {
            // 根据实际情况，满100减10，一般顾客都会选择分段付费，即如果总价大于200，会选择分两次付款，每次付款的数额都大于100而且还可以得到优惠
            totalD =  Math.floor(total / 100) * (100-10) + total % 100;
        } else if (total % 100 >= 92) {
            // 如果金额差8块以内就会超过100，那么顾客会选择再购买一斤苹果，从而还会得到减10的优惠，即总价会减2元
            totalD =  Math.floor(total / 100) * (100-10) + total % 100 - 2;
        }
        return Result.success(totalD);
    }


}
