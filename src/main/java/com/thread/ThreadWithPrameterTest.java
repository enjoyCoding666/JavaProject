package com.thread;

import java.util.HashMap;
import java.util.Map;

/**
 * 通过getter(),setter()向线程传递参数。
 */
public class ThreadWithPrameterTest {
  private   static   Map<String,String> hashMap=new HashMap<>();

    public static void main(String[] args) {
        MyThread myThread=new MyThread();
        myThread.setHashMap(hashMap);
        myThread.start();
    }

    static class MyThread extends Thread {
       Map<String,String> hashMap;

        public void setHashMap( Map<String,String> hashMap){
            this.hashMap=hashMap;
        }

        @Override
        public void run() {
            for(int i=0;i<5;i++) {
                 hashMap.put("key"+i,String.valueOf(i));
            }
            for(int i=0;i<5;i++) {
                System.out.println( hashMap.get("key"+i));
            }

        }
    }
}
