package com.example.demo;

import com.example.demo.common.Result;
import com.example.demo.controller.TotalMoneyController;
import com.example.demo.services.Impl.ServiceDemo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@SpringBootTest(classes = DemoApplication.class)
class DemoApplicationTests {
    @Autowired
    ServiceDemo serviceDemo;

    @Autowired
    TotalMoneyController totalMoneyController;

    /**
     *1、有一家超市，出售苹果和草莓。其中苹果 8 元/斤，草莓 13 元/斤。
     * 现在顾客 A 在超市购买了若干斤苹果和草莓，需要计算一共多少钱？
     * 请编写函数，对于 A 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。
     */
    @Test
    void firstQuestion() {
        Map<String,Double> map = new HashMap<>();
        map.put("applePrice",8.0);
        map.put("appleWeight", (double) 5);

        map.put("strawBerryPrice",13.0);
        map.put("strawBerryWeight", (double) 3);
        Result<?> totalMoney = totalMoneyController.getFirstTotalMoney(map);
        log.info("A 购买的水果的总价={}",totalMoney);
    }

    /**
     * 2、超市增加了一种水果芒果，其定价为 20 元/斤。
     * 现在顾客 B 在超市购买了若干斤苹果、 草莓和芒果，需计算一共需要多少钱？
     * 请编写函数，对于 B 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。
     */
    @Test
    void secondQuestion(){
        Map<String,Double> map = new HashMap<>();
        map.put("applePrice",8.0);
        map.put("appleWeight", (double) 5);

        map.put("strawBerryPrice",13.0);
        map.put("strawBerryWeight", (double) 3);

        map.put("mongoPrice",20.0);
        map.put("mongoWeight", (double) 4);
        Result<?> totalMoney = totalMoneyController.getSecondThirdTotalMoney(map);
        log.info("B 购买的水果的总价={}",totalMoney);
    }

    /**
     * 3、超市做促销活动，草莓限时打 8 折。
     * 现在顾客 C 在超市购买了若干斤苹果、 草莓和芒果，需计算一共需要多少钱？
     * 请编写函数，对于 C 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。
     */
    @Test
    void thirdQuestion(){
        Map<String,Double> map = new HashMap<>();
        map.put("applePrice",8.0);
        map.put("appleWeight", (double) 5);

        map.put("strawBerryPrice",13*0.8);
        map.put("strawBerryWeight", (double) 3);

        map.put("mongoPrice",20.0);
        map.put("mongoWeight", (double) 4);
        Result<?> totalMoney = totalMoneyController.getSecondThirdTotalMoney(map);
        log.info("C 购买的水果的总价={}",totalMoney);
    }

    /**
     * 4、促销活动效果明显，超市继续加大促销力度，购物满 100 减 10 块。
     * 现在顾客 D 在超市购买了若干斤苹果、 草莓和芒果，需计算一共需要多少钱？
     * 请编写函数，对于 D 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。
     */
    @Test
    void fourthQuestion(){

        Map<String,Double> map = new HashMap<>();
        map.put("applePrice",8.0);
        map.put("appleWeight", (double) 5);

        map.put("strawBerryPrice",13*0.8);
        map.put("strawBerryWeight", (double) 3);

        map.put("mongoPrice",20.0);
        map.put("mongoWeight", (double) 4);
        Result<?> totalMoney = totalMoneyController.getFourthTotalMoney(map);
        log.info("D 购买的水果的总价={}",totalMoney);
    }

}
