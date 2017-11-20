package com.example.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on  十一月
 */
public class OrderExample {

    public List<Order> initOrderList() {
        List<Order> orderList=new ArrayList<Order>();
        orderList.add(new Order("17065482456","3106000020793953","2017-08-28 13:45:42"));
        orderList.add(new Order("17065831710","3700000020542041","2017-08-17 11:39:08"));
        orderList.add(new Order("17031652563","2103000016625062","2017-08-22 22:04:22"));
        orderList.add(new Order("17031697520","2100000016693527","2017-08-25 18:51:34"));
        return orderList;
    }
}
