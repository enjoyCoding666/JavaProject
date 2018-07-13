package com.concurrent;

import java.util.Map;
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
            removeThread.start();
            Thread.sleep(5*1000);
            System.out.println("开始遍历ConcurHashMap:");
            for(Map.Entry<String ,String > mapEntry : concurrentHashMap.entrySet()) {
                    System.out.println("key: "+mapEntry.getKey()+"   ,value: "+mapEntry.getValue());
            }
    }

   static class AddThread implements Runnable {

        @Override
        public void run() {
                for(int i=1;i<10;i++) {
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
