package com.thread;

public class YieldTest implements  Runnable{

    @Override
    public void run() {
        for(int i=0;i<=10;i++) {
            System.out.println(Thread.currentThread().getName()+",当前计数："+i);
            if(5==i) {
                Thread.yield();
                System.out.println(Thread.currentThread().getName()+"执行yield，让所有线程继续竞争。");
            }
        }
    }

    public static void main(String[] args)  {
        Thread thread1=new Thread( new YieldTest(),"thread1");
        Thread thread2=new Thread( new YieldTest(),"thread2" );
        thread1.start();
        thread2.start();

    }

}
