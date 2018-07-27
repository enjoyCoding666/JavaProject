package com.concurrent.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 Condition类的awiat方法和Object类的wait方法等效
 Condition类的signal方法和Object类的notify方法等效
 Condition类的signalAll方法和Object类的notifyAll方法等效
 */
public class ConditionDemo {
   private  static Lock lock=new ReentrantLock();
   private static Condition condition=lock.newCondition();

    public static void main(String[] args)   {
         ThreadSignal threadSignal =new ThreadSignal();
         threadSignal.start();

         try {
             lock.lock();
             System.out.println("在主线程中加锁。");
             System.out.println("在主线程中利用Condition使线程等待。");
             condition.await();
         }catch (InterruptedException e) {
             e.printStackTrace();
         }finally {
             lock.unlock();
             System.out.println("在主线程中解锁。");
         }

//    以下代码，为什么没有同步成功？仍旧报错：IllegalMonitorStateException
//        synchronized (threadSignal) {
//            try{
//                System.out.println("在主线程中等待。");
//                condition.await();
//                System.out.println("在主线程中结束");
//            }catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

    }


  static class ThreadSignal extends  Thread {

      @Override
      public void run() {
          try {
              lock.lock();
              System.out.println("在线程"+Thread.currentThread().getName()+"中加锁");
              condition.signal();
              System.out.println("在线程"+Thread.currentThread().getName()+"中唤醒。");
          }catch (Exception e) {
               e.printStackTrace();
          }finally {
               lock.unlock();
               System.out.println("在线程"+Thread.currentThread().getName()+"中解锁。");
          }
      }
  }


}
