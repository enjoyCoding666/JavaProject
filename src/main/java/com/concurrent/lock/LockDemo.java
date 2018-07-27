package com.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 可重入锁ReentrantLock。功能类似于synchronized。保证线程同步。防止多个线程同时并发访问程序的某些资源。
 */
public class LockDemo {
    public static void main(String[] args) {
        Thread thread1=new Thread(new Ticket(),"1");
        Thread thread2=new Thread(new Ticket(),"2");
        Thread thread3=new Thread(new Ticket(),"3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}


class Ticket implements Runnable{
    private int tick = 100;
    private Lock lock = new ReentrantLock();
    @Override
    public void run(){
        while(true){
            // 上锁
            lock.lock();
            try{
                if(tick > 0){
                    try{
                        Thread.sleep(200);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"完成售票,余票为: "+ --tick);
                }
            }finally{
                // 释放锁
                lock.unlock();
            }
        }
    }
}
