package com.thread;

/**
 *  线程的join()可以让别的线程插队
 */
public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1=new Thread( new MyThread("thread1") );
        Thread thread2=new Thread( new MyThread("thread2") );
        thread1.start();
        thread2.start();
        thread1.join();
//        thread2.join();

    }
}
