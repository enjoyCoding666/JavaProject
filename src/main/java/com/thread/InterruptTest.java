package com.thread;

public class InterruptTest {

    public static void main(String[] args) {
        for(int i=0;i<5;i++){
                Thread thread=new Thread( new InterruptThread());
                thread.start();
                thread.interrupt();
        }
    }

     static  class   InterruptThread implements  Runnable  {
         @Override
         public void run() {
             try {
                 System.out.println("InterruptTest.");
                 Thread.sleep(2000);

             } catch (InterruptedException e) {
                 System.out.println("线程处于阻塞状态时，中断线程，就会抛出异常。");
                 e.printStackTrace();
             }

         }
     }
}
