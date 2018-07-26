package com.concurrent.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo {
   private  static Lock lock=new ReentrantLock();
   private static Condition condition=lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
         MyThread myThread=new MyThread();
         myThread.start();

        System.out.println("利用Condition阻塞线程。"+MyThread.currentThread().getName());
        condition.await();


    }


  static class MyThread extends  Thread {

      @Override
      public void run() {
          try {
              lock.lock();
              System.out.println(Thread.currentThread().getName()+"准备唤醒。");
              condition.signal();

          }catch (Exception e) {
               e.printStackTrace();
          }finally {
               lock.unlock();
          }
      }
  }

}
