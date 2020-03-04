package com.java8.stream;

import com.bean.Worker;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: EnjoyCoding
 * @Date: 2020\1\20 0020 20:41
 * @Description:
 */
public class StreamToMap {

    public static void main(String[] args) {
        toMapTest();
    }

    public static void toMapTest() {
        List<Worker> list = new ArrayList<>();
        list.add(new Worker("123",18,"lin"));
        list.add(new Worker("456",28,"chen"));
        list.add(new Worker("789",38,"wu"));
        //key不可重复，否则会报错"Duplicate key"
//        list.add(new Worker("123",18,"li"));
        //value不可为null，否则会报错"空指针异常"
//        list.add(new Worker("000",18,null));
        Map<String, String> map = list.stream().collect(Collectors.toMap(Worker::getId, Worker::getName));
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey()+","+entry.getValue());
        }
    }

}
