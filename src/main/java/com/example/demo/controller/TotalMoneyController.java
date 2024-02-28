package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.entity.*;
import com.example.demo.services.Impl.CustomerServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
public class TotalMoneyController {
    @Autowired
    CustomerServiceImp customerServiceImp;

    /**
     * 计算总价
     * @param map
     * @return
     */
    @PostMapping("/api/getTotalMoney")
    public Result<?> getTotalMoney(@RequestBody Map<String, Customer> map){
        Customer customer = map.get("customer");
        String custName = customer.getName();
        double total = customerServiceImp.calculateTotalPrice(customer);
        return Result.success(total,custName+"购买的水果总价");
    }

    /**
     * 计算搞活动后苹果、草莓总、芒果总价
     * @param map
     * @return
     */
    @PostMapping("/api/getDiscountTotalMoney")
    public Result<?> getDiscountTotalMoney(@RequestBody Map<String, Customer> map){
        Customer customer = map.get("customer");
        String custName = customer.getName();
        double total = customerServiceImp.calculateTotalPrice(customer);

        double totalD = 0;
        if (total % 100 < 92) {
            // 根据实际情况，满100减10，一般顾客都会选择分段付费，即如果总价大于200，会选择分两次付款，每次付款的数额都大于100而且还可以得到优惠
            totalD =  Math.floor(total / 100) * (100-10) + total % 100;
        } else if (total % 100 >= 92) {
            // 如果金额差8块以内就会超过100，那么顾客会选择再购买一斤苹果，从而还会得到减10的优惠，即总价会减2元
            totalD =  Math.floor(total / 100) * (100-10) + total % 100 - 2;
        }
        return Result.success(totalD,custName+"购买的水果总价");

    }
}
