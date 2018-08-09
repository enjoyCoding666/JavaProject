package com.concurrent;

/**
 *  模拟CAS 算法。
 *  CAS（Compare and swap）比较和替换是设计并发算法时用到的一种技术。
 *  简单来说，比较和替换是使用一个期望值和一个变量的当前值进行比较，如果当前变量的值与我们期望的值相等，就使用一个新值替换当前变量的值。
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

                    boolean b = cas.compareAndSet(expectedValue, (int)(Math.random()*100));
                    System.out.println(b);
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

         // 无论更新成功与否,都返回修改之前的内存值
         public  synchronized  int compareAndSwap(int expectedValue,int newValue) {
             //获取旧值
             int oldValue=value;
             if(oldValue==expectedValue) {
                    this.value=newValue;
             }
               return  oldValue;
         }

       //比较当前值和期望值，判断是否设置成功
        public synchronized boolean compareAndSet(int expectedValue, int newValue) {
              return  expectedValue==compareAndSwap(expectedValue,newValue);
         }
    }
}
