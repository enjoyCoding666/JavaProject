package com.thread;

 public class SynchronizedDemo implements Runnable {
        public static void main(String args[]) {
            SynchronizedDemo mt = new SynchronizedDemo();
            Thread t1 = new Thread(mt, "t1");
            Thread t2 = new Thread(mt, "t2");
            Thread t3 = new Thread(mt, "t3");
            Thread t4 = new Thread(mt, "t4");
            Thread t5 = new Thread(mt, "t5");
            Thread t6 = new Thread(mt, "t6");
            t1.start();
            t2.start();
            t3.start();
            t4.start();
            t5.start();
            t6.start();
        }

     /**
      * 同步方法，加锁后一次只能有一个线程访问该方法，执行后该方法后，其他线程才能访问。
      * 写在前面代码中的线程不一定就能先抢到线程的使用权。每次运行的结果可能都不一样。
      * 如果去掉synchronized，那么可能出现"线程名称t1"之后紧跟的不是"t1调用结束"，而是"线程名称:t2"
      * 该同步方法锁等同于以下对象锁:
      *  public  void run() {
      *       synchronized(this){
      *           System.out.println("线程名称:"+Thread.currentThread().getName());
      *           System.out.println(Thread.currentThread().getName()+"调用结束");
      *       }
      *     }
      */
        public synchronized void run() {
            System.out.println("线程名称:"+Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getName()+"调用结束");
        }
 }

