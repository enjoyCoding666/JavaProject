package com.concurrent.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;



public class ThreadNum {



//    private  static final ExecutorService MY_EXECUTOR = Executors.newFixedThreadPool(5);

    /**
     *  自定义ThreadFactory
     *  自定义线程池
     *
     */
    private static final ExecutorService THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(
            5, 20,
            2, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(1000),
            ThreadFactoryImpl.builder().threadName("thead-my-").build());



    public static void main(String[] args)  {
        THREAD_POOL_EXECUTOR.execute(()-> System.out.println(Thread.currentThread().getName()+ ":first thread."));
        THREAD_POOL_EXECUTOR.execute(()-> System.out.println(Thread.currentThread().getName()+ ":second thread."));
        THREAD_POOL_EXECUTOR.shutdown();
    }




}
