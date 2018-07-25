package com.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * 同步辅助类:完成一组线程执行前,使得一个或多个线程一直等待,可以实现类似计数器的功能。
 * 比如有一个任务A，它要等待其他4个任务执行完毕之后才能执行，此时就可以利用CountDownLatch来实现这种功能了。
 *
 * Created by bysocket on 16/4/26.
 */
public class CountDownLatchDemo {
    private static final int COUNT=2;
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(COUNT);

        for(int i=0;i<COUNT;i++) {
            new Thread(){
                @Override
                public void run() {
                    try {
                        System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                        Thread.sleep(3000);
                        System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
                        latch.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                };
            }.start();
        }

        try {
            System.out.println("等待2个子线程执行完毕...");
            latch.await();
            System.out.println("2个子线程已经执行完毕");
            System.out.println("继续执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}