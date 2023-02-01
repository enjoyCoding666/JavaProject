package com.java8.completefuture;

import java.util.concurrent.*;

public class OfAllGetSimpleDemo {
    public static void main(String[] args) throws Exception {
        allOfTest();
    }

    public static void allOfTest() throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CompletableFuture<Void> cf1 = CompletableFuture.runAsync(
                () -> System.out.println("cf1 ok."), executorService);
        CompletableFuture<Void> cf2 = CompletableFuture.runAsync(
                () -> System.out.println("cf2 ok."), executorService);

        //将两个任务组装成一个新的任务，总共的超时时间为2s
        CompletableFuture.allOf(cf1, cf2).get(2, TimeUnit.SECONDS);
    }
}
