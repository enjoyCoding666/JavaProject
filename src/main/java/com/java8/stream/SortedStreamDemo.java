package com.java8.stream;

import com.bean.Order;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.naturalOrder;

public class SortedStreamDemo {


    public void sortByString() {
        //设置 order对象属性，以下是lombok的写法，相当于 setter
        Order order1=Order.builder().dateStr("2021-10-01 00:00:00").price(33.3).build();
        Order order2=Order.builder().dateStr("2021-11-01 00:00:00").price(1.3).build();
        Order order3=Order.builder().dateStr("2021-12-01 00:00:00").price(55.3).build();
        //添加null测试
        Order order0=Order.builder().weight(null).dateStr(null).price(null).build();

        List<Order> list= new ArrayList<>();
        list.add(order1);
        list.add(order2);
        list.add(order3);
        list.add(order0);

        List<Order> orderList3 = list.stream().sorted(this::sort).collect(Collectors.toList());
        System.out.println("orderList3："+orderList3);
    }

    public int sort(Order o1, Order o2) {
        if (o1.getDateStr() == null) {
            return 1;
        }
        if (o2.getDateStr() == null) {
            return -1;
        }
        //升序
        return o1.getDateStr().compareTo(o2.getDateStr());
    }
}
