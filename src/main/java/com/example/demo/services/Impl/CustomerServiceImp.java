package com.example.demo.services.Impl;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Fruit;
import com.example.demo.services.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {
    /**
     * 计算顾客购买水果实现类
     * @param customer
     * @return
     */
    @Override
    public double calculateTotalPrice(Customer customer) {
        List<Fruit> fruitList = customer.getFruitList();
        double total = fruitList.stream().mapToDouble(item -> item.getPrice() * item.getWeight()).sum();
        return total;
    }
}
