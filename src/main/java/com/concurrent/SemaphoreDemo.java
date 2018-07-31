package com.concurrent;

import java.util.concurrent.Semaphore;

/**
 * Semaphore翻译成字面意思为 信号量，Semaphore可以控制同时访问的线程个数，通过 acquire() 获取一个许可，如果没有就等待，而 release() 释放一个许可。
 */
public class SemaphoreDemo {
    private static Semaphore semaphore=new Semaphore(5);
    public static void main(String[] args) {
        for(int i=0;i<8;i++) {
            new Thread (new Worker(i)) .start();
        }

    }

    static class   Worker implements Runnable {
        private  int number;
        public Worker(int number) {
             this.number=number;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("工人"+number+"正在使用某一台机器");
                Thread.sleep(5*1000);
                semaphore.release();
                System.out.println("---------------->工人"+number+"停止使用某一台机器");
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
