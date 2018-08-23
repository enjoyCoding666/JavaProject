package com.concurrent;

import java.util.concurrent.*;

public class FutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor=Executors.newCachedThreadPool();
        Task task=new Task();
        //通过Future类获取任务运行结果
        Future<String> future= executor.submit(task);
        executor.shutdown();
        String result=future.get();
        System.out.println("Future的返回结果为:"+result);

    }


    /**
     * 通过实现Callable接口新建线程。 重写接口中的call()方法。
     * Callable<T> 支持泛型。
     */
   static class Task implements Callable<String> {
       String test="test";

        @Override
        public String call()  {
            return test;
        }
    }
}
