package com.java8.lambda;

public class LambdaThread {
    public static void main(String[] args) {
        new Thread(
                () -> System.out.println("New thread")
        ).start();
        System.out.println("Main thread");
    }
}
