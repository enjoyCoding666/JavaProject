package com.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁ReentrantReadWriteLock。多个线程操作同一资源，读和读可以共存，写写不共存，写读不共存。
 */
public class ReadWriteLockDemo {

    public static void main(String[] args) {
          ReadWrite readWrite=new ReadWrite();

          for(int i=0;i<5;i++) {
              new Thread(new Runnable() {
                  @Override
                  public void run() {
                      readWrite.get();
                  }
              }).start();

              new Thread(new Runnable() {
                  @Override
                  public void run() {
                      readWrite.set();
                  }
              }).start();
          }
    }
}


   class  ReadWrite {
      private ReadWriteLock  readWriteLock=new ReentrantReadWriteLock();

       /**
        * 进行"读"操作
        */
      public void get() {
          try {
              readWriteLock.readLock().lock();
              System.out.println("线程"+Thread.currentThread().getName()+"进行读取。");
              Thread.sleep(2*1000);
          }catch (InterruptedException e) {
              e.printStackTrace();
          }finally {
              readWriteLock.readLock().unlock();
              System.out.println("线程"+Thread.currentThread().getName()+"读取完毕。");
          }
      }

       /**
        * 进行"写"操作
        */
      public  void  set(){
          try {
              readWriteLock.writeLock().lock();
              System.out.println("线程"+Thread.currentThread().getName()+"进行写入。");
              Thread.sleep(2*1000);
          }catch (InterruptedException e) {
              e.printStackTrace();
          }finally {
              readWriteLock.writeLock().unlock();
              System.out.println("线程"+Thread.currentThread().getName()+"写入完毕。");
          }
      }
   }
