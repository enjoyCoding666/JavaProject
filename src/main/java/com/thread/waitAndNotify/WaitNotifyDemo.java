package com.thread.waitAndNotify;

public class WaitNotifyDemo {
    public static void main(String[] args) throws InterruptedException {

        Object object = new Object();

        SynWaitThread a = new SynWaitThread(object);
        a.start();

        SynNotifyThread c = new SynNotifyThread(object);
        c.start();
    }
}