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
//        toMapValueBeanTest();
    }


    public static void toMapTest() {
        List<Worker> list = new ArrayList<>();
        list.add(new Worker("123",18,"lin"));
        list.add(new Worker("123",18,"li"));
        list.add(new Worker("000",18,null));
        //如果没有对重复key的处理 (k1,k2)->k2 ，那么key重复时会报错"Duplicate key"， 而且value为null时会报错"空指针异常"。
        Map<String, String> map = list.stream().collect(Collectors.toMap(Worker::getId, Worker::getName));
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey()+","+entry.getValue());
        }
    }

    public static void toMapTest2() {
        List<Worker> list = new ArrayList<>();
        list.add(new Worker("123",18,"lin"));
        list.add(new Worker("456",28,"chen"));
        list.add(new Worker("789",38,"wu"));
        list.add(new Worker("123",18,"li"));
        list.add(new Worker("000",18,null));
        //(k1,k2)->k2 处理重复key。如果k1和k2相同，就取k2对应的value
        Map<String, String> map = list.stream().collect(Collectors.toMap(Worker::getId, Worker::getName, (k1,k2)->k2));
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey()+","+entry.getValue());
        }
    }


    public static void toMapValueBeanTest() {
        List<Worker> list = new ArrayList<>();
        list.add(new Worker("123",18,"lin"));
        list.add(new Worker("456",28,"chen"));
        list.add(new Worker("123",18,"li"));
        list.add(new Worker("000",18,null));
        //value 为对象的map
        Map<String, Worker> map = list.stream().collect(Collectors.toMap(Worker::getId, worker -> worker, (k1,k2)->k2));
        for (Map.Entry<String, Worker> entry : map.entrySet()) {
            System.out.println(entry.getKey()+","+entry.getValue());
        }
    }
}
