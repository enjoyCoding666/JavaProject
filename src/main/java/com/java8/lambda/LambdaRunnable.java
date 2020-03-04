package com.java8.lambda;

public class LambdaRunnable {
    public static void main(String[] args) {
        Runnable race2 = () -> System.out.println("Hello world !");
        race2.run();

//        传统的代码表现方式如下：
//        Runnable race1 = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Hello world !");
//            }
//        };
//        race1.run


    }
}
