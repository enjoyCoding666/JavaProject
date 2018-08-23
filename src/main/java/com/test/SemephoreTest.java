package com.test;

import java.util.concurrent.Semaphore;

public class SemephoreTest {
    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(5);
        semaphore.release();
        System.out.println("可用的permit数量为："+semaphore.availablePermits());
    }
}
