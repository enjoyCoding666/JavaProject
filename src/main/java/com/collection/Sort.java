package com.collection;

import com.bean.Order;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by lenovo on  十一月
 */
public class Sort {
    public List<Order> phoneNumberSort(List<Order> list){
        Collections.sort(list, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o1.getPhoneNumber().compareTo(o2.getPhoneNumber())==0 ?
                        o1.getDoneCode().compareTo(o2.getDoneCode()) : o1.getPhoneNumber().compareTo(o2.getPhoneNumber()) ;
            }
        });
        return list;
    }
}
