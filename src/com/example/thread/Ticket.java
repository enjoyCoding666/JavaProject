/**
 * 
 */
package com.example.thread;

/**
 * @author Administrator
 *
 */
class Ticket implements Runnable {//通过Runnable接口实现多线程机制
    public void run() {
        for (int i = 0; i < 10; ++i) {  //这里为什么要循环？当然啦，又不是只卖一张票
            sale();
        }
    }
 
    public synchronized void sale() {       //在方法名前面添加互斥锁,保证同步
        if (count > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(count--);
        }
    }
 
    public static void main(String[] args) {
        Ticket he = new Ticket();
        Thread h1 = new Thread(he);   //将runnable对象做为参数，新建线程
        Thread h2 = new Thread(he);   //可以想象成三个卖票点
        Thread h3 = new Thread(he);
        h1.start();
        h2.start();
        h3.start();
    }
 
    private int count = 5;
}
