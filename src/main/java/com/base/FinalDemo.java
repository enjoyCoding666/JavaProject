package com.base;

/**
 * Created by lenovo on  七月
 */
public class FinalDemo {
    private  final  int  age=18;
    private  final  String name="lin";

    public  void finalTest() {
//以下两处都会报错，被修饰为final的基本类型数据的值，不可以改变。
//被final修饰的引用类型的变量，则在对其初始化之后便不能再让其指向另一个对象
//        age=28;
//        name="test";

    }
}
