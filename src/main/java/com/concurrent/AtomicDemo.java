package com.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用AtomicInteger保证线程安全。AtomicInteger类,是一个对于变量可以进行原子性操作的类；核心是CAS无锁算法。
 * CAS算法是基于乐观锁的实现方法，在不需要锁的情况下，并且在并发量不高的情况下完成的原子性的操作。
 * 主要原理是当一个线程去修改这个值的时候，会进入一个while循环，并且不断的尝试compareAndSet()方法，
 * 也就是不断地比较内存值和期望值，如果相等就修改，不相等就返回false，当值修改完毕结束死循环；
 *
 * 以下程序多运行几次，会发现Integer的计算结果可能不一样，而AtomicInteger每次的结果都是一样的。
 */
public class AtomicDemo {
    private static  final int COUNT=100;
    private static AtomicInteger atomicInteger=new AtomicInteger(0);
    private static Integer integer=0;
    public static void main(String[] args) throws InterruptedException {
            for(int i=0;i<COUNT;i++) {
                new Thread (new AtomicIntegerThread()).start();
            }
        Thread.sleep(2*1000);             //休眠主线程，这样主线程才能获取到最终的计算结果
        System.out.println("Integer最终结果为为："+integer);
        System.out.println("AtomicInteger最终结果为为："+atomicInteger);

    }


    static class AtomicIntegerThread implements Runnable {

        @Override
        public void run() {
            atomicInteger.getAndIncrement();
            integer++;
        }

    }
}
