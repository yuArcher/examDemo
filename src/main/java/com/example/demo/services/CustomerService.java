package com.example.demo.services;

import com.example.demo.entity.Customer;

public interface CustomerService {
    /**
     * 计算顾客购买水果接口
     * @param customer
     * @return
     */
    double calculateTotalPrice(Customer customer);
}
