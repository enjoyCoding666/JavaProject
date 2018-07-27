package com.thread;


/**
 *  使当前线程从执行状态（运行状态）变为可执行态（就绪状态）。cpu会从众多的可执行态里选择。
  当前也就是刚刚的那个线程还是有可能会被再次执行到的，并不是说一定会执行其他线程而该线程在下一次中不会执行到了。
 */
public class YieldDemo implements  Runnable{

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
        Thread thread1=new Thread( new YieldDemo(),"thread1");
        Thread thread2=new Thread( new YieldDemo(),"thread2" );
        thread1.start();
        thread2.start();

    }

}
