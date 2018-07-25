/**
 * 
 */
package com.thread;

/**
 * @author Administrator
 *
 */
class SynchronizedDemo2 implements Runnable {
    private int count = 5;
    @Override
    public void run() {
        for (int i = 0; i < 10; ++i) {
            sale();
        }
    }

    /**
     * 通过synchronized保证一张票只卖一次。
     */
    public synchronized void sale() {
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
        SynchronizedDemo2 he = new SynchronizedDemo2();
        Thread h1 = new Thread(he);
        Thread h2 = new Thread(he);
        Thread h3 = new Thread(he);
        h1.start();
        h2.start();
        h3.start();
    }
 

}
