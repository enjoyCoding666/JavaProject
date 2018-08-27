package com.concurrent;

import java.util.concurrent.*;

/**
 * FutureTask提供了2个构造器：
 * public FutureTask(Callable<V> callable) {   }
 * public FutureTask(Runnable runnable, V result) {  }
 * 另外，FutureTask是Future接口的一个唯一实现类。
 * 跟Future一样，FutureTask可以通过get()方法获取返回值。
 */
public class FutureTaskDemo {
    public static void main(String[] args) {
        ExecutorService executors=Executors.newCachedThreadPool();
        FutureTask<Integer> futureTask =new FutureTask<>(new Task());
        executors.submit(futureTask);
        executors.shutdown();
        try {
            System.out.println("任务运行结果为："+futureTask.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }


   static class Task implements Callable<Integer> {
        int sum=0;

        @Override
        public Integer call() throws Exception {
            for(int i=0;i<10;i++) {
                sum+=i;
            }
            return sum ;
        }
    }

}
