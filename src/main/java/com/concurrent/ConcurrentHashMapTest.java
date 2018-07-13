package com.concurrent;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by lenovo on  七月
 */
public class ConcurrentHashMapTest {
    private static ConcurrentHashMap<String,String> concurrentHashMap=new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {
            Thread addThread=new Thread(new AddThread());
            Thread removeThread =new Thread(new RemoveThread());
            addThread.start();
            Thread.sleep(2*1000);
            removeThread.start();
    }

   static class AddThread implements Runnable {

        @Override
        public void run() {
                for(int i=1;i<5;i++) {
                    concurrentHashMap.put("key"+i,String.valueOf(i));
                    System.out.println("add key :"+i+"  ,value:");
                }
        }
    }


   static  class  RemoveThread implements  Runnable {

        @Override
        public void run() {
            for(int i=1;i<5;i++) {
                concurrentHashMap.remove("key"+i);
                System.out.println("remove key:"+i);
            }
        }
    }
}
