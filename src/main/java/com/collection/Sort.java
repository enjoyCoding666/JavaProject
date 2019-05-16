package com.collection;

import com.bean.Order;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Sort {
    public List<Order> phoneNumberSort(List<Order> list){
        list.sort((o1, o2) -> o1.getPhoneNumber().compareTo(o2.getPhoneNumber()) == 0 ?
                o1.getDoneCode().compareTo(o2.getDoneCode()) : o1.getPhoneNumber().compareTo(o2.getPhoneNumber()));
        return list;
    }
}
