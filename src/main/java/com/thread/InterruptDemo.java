package com.thread;

/**
 *  interrupt() 方法只是改变中断状态而已，它不会中断一个正在运行的线程。
 这一方法实际完成的是，给受阻塞的线程发出一个中断信号，这样受阻线程就得以退出阻塞的状态。
 更确切的说，如果线程被Object.wait, Thread.join和Thread.sleep三种方法之一阻塞，此时调用该线程的interrupt()方法，
 那么该线程将抛出一个 InterruptedException中断异常（该线程必须事先预备好处理此异常），从而提早地终结被阻塞状态。
 如果线程没有被阻塞，这时调用 interrupt()将不起作用，直到执行到wait(),sleep(),join()时,才马上会抛出 InterruptedException。
 */
public class InterruptDemo {

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
                 System.out.println("InterruptDemo.");
                 Thread.sleep(2000);

             } catch (InterruptedException e) {
                 System.out.println("线程处于阻塞状态时，中断线程，就会抛出异常。");
                 e.printStackTrace();
             }

         }
     }
}
