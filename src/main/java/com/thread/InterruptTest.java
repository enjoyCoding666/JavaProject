package com.thread;

public class InterruptTest {

    public static void main(String[] args) {
        for(int i=0;i<5;i++){
            try {
                Thread thread=new Thread( new InterruptThread());
                thread.start();
                Thread.sleep(1000*5);
                thread.interrupt();
                System.out.println("线程继续运行。");
            } catch (InterruptedException e) {
                System.out.println("线程处于阻塞状态时，中断线程，就会抛出异常。");
            }
        }
    }

     static  class   InterruptThread implements  Runnable  {
         @Override
         public void run() {
             System.out.println("运行线程.");
         }
     }
}
