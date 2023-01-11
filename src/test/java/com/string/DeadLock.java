package com.string;


public class DeadLock {

    private Object obj1 = new Object();
    private Object obj2 = new Object();


    public void lock() {
        new Thread( ()-> {
            synchronized (obj1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized(obj2) {
                    System.out.println("持有对象1，请求对象2");
                }

            }

        }).start();

        new Thread( ()-> {
            synchronized (obj2) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized(obj1) {
                    System.out.println("持有对象2，请求对象1");
                }

            }

        }).start();
    }



}
