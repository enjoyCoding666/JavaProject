package com.thread;

public class YieldTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1=new Thread( new MyThread("thread1") );
        Thread thread2=new Thread( new MyThread("thread2") );
        thread1.start();
        thread2.start();

        //准备添加yeild()方法

    }
}
