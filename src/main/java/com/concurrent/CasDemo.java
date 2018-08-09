package com.concurrent;

/**
 *
 *  CAS（Compare and swap）比较和替换是设计并发算法时用到的一种技术。
 *  简单来说，比较和替换是使用一个期望值和一个变量的当前值进行比较，如果当前变量的值与我们期望的值相等，就使用一个新值替换当前变量的值。
 *  以下用同步锁synchronized模拟CAS 算法。注意：真正的CAS算法是无锁的。
 */
public class CasDemo {
    public static void main(String[] args) {
        final CompareAndSwap cas = new CompareAndSwap();

        for(int i=0; i<10; i++){
            // 创建10个线程,模拟多线程环境
            new Thread(new Runnable(){
                @Override
                public void run(){
                    int expectedValue = cas.get();

                    boolean b = cas.compareAndSwap(expectedValue, (int)(Math.random()*5));
                }
            }).start();
        }
    }


    static   class  CompareAndSwap{
         private  int value;

        // 获取内存值
         public synchronized  int get() {
             return  value;
         }

         // 比较当前值和期望值,相同就替换。
         public  synchronized  boolean compareAndSwap(int expectedValue,int newValue) {
             //获取旧值
             int oldValue=value;
             if(oldValue==expectedValue) {
                    this.value=newValue;
                    System.out.println(Thread.currentThread().getName()+"比较当前值和期望值，结果一致，将其替换为新值。");
                    return true;
             }
             System.out.println(Thread.currentThread().getName()+"比较当前值和期望值，结果不一致，不替换为新值");
             return  false;
         }
    }
}
