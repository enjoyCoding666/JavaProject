package com.thread;

public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1=new Thread( new MyThread("thread1") );
        Thread thread2=new Thread( new MyThread("thread2") );
        thread1.start();
        thread2.start();
        thread1.join();                  //join()可以让别的线程插队
//        thread2.join();

    }
}
