package com.java8.stream;


import com.bean.Order;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.naturalOrder;

public class SortedDateDemo {


    /**
     * nullsFirst()表示如果属性为null，就放到最前面。
     * nullsFirst()表示如果属性为null，就放到最前面。
     * naturalOrder()表示自然排序(一般是升序)，
     * Comparator.reverseOrder()表示 降序。
     *
     *
     */
    public void orderSort() {
        Order order1 =new Order();
        order1.setDateStr("2021-10-01 00:00:00");
        order1.setCreateTime(toDate("2022-01-01 00:00:00", "yyyy-MM-dd HH:mm:ss"));

        Order order2 =new Order();
        order2.setDateStr("2021-10-01 00:00:00");
        order2.setCreateTime(toDate("2022-02-01 00:00:00", "yyyy-MM-dd HH:mm:ss"));

        Order order3 =new Order();
        order3.setDateStr("2021-10-03 00:00:00");
        order3.setCreateTime(toDate("2022-02-01 00:00:00", "yyyy-MM-dd HH:mm:ss"));

        Order order4 =new Order();
        order4.setDateStr(null);
        order4.setCreateTime(null);

        List<Order> list= new ArrayList<>();
        list.add(order1);
        list.add(order2);
        list.add(order3);
        list.add(order4);

        //naturalOrder()表示自然排序(一般是升序)，Comparator.nullsLast表示如果属性为null，就放到最后面
        Comparator<Order> comparator =  Comparator.comparing(Order::getDateStr, Comparator.nullsLast(naturalOrder()) );
        List<Order> orderList = list.stream().sorted(comparator).collect(Collectors.toList());
//        System.out.println("orderList："+orderList);

        //Comparator.reverseOrder表示 降序，nullsFirst表示如果属性为null，就放到最前面。
        Comparator<Order> comparator2 = Comparator.comparing(Order::getDateStr, Comparator.nullsFirst(Comparator.reverseOrder()));
        List<Order> orderList2 = list.stream().sorted(comparator2).collect(Collectors.toList());
        System.out.println("orderList2："+ orderList2);

        //先按第一个字段降序，再按第二个字段降序，如果属性为null，就放到最后面。
        Comparator<Order> comparator3 =  Comparator.comparing(Order::getDateStr, Comparator.nullsLast(Comparator.reverseOrder()))
                                                    .thenComparing(Order::getCreateTime, Comparator.nullsLast(Comparator.reverseOrder()));
        List<Order> orderList3 = list.stream().sorted(comparator3).collect(Collectors.toList());
//        System.out.println("orderList3："+ orderList3);
    }

    public static Date toDate(String dateTimeStr, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime localDateTime = LocalDateTime.parse(dateTimeStr, formatter);
        return Date.from(localDateTime.atZone( ZoneId.systemDefault()).toInstant());
    }


}
