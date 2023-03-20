package com.java8.completefuture;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

@Slf4j
public class WhenCompleteDemo {



    public static void main(String[] args) {
        whenComplete();
    }


    public static void whenComplete()  {
        //该线程池仅用于示例，实际建议使用自定义的线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        String word1 = "word1";
        String word2 = "word2";

        CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(
                () -> getResult(word1, 1000), executorService)
                .whenComplete((result, throwable) ->{
                    if (throwable != null) {
                        log.error("completableFuture1  error:", throwable);
                    }
                });

        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(
                () -> getResult(word2, 1500), executorService)
                .whenComplete((result, throwable) ->{
                    if (throwable != null) {
                        log.error("completableFuture2  error:", throwable);
                    }
                });

        List<CompletableFuture<String>> futureList = new ArrayList<>();
        futureList.add(completableFuture1);
        futureList.add(completableFuture2);

        List<String> resultList = new ArrayList<>();
        //allOf()聚合所有任务，join阻塞
        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0])).join();
        futureList.forEach(f -> resultList.add(getFutureResult(f,2000)));


        //以下这段代码，拿不到返回值，值得思考
//        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0]));
//        allFutures.thenRun(() ->
//                futureList.forEach(f -> resultList.add( getFutureResult(f))));

        resultList.forEach(System.out::println);
    }

    private static String getResult(String result, int millis) {
        try {
            //任务耗时。可以分别设置1000和3000，看未超时和超时的不同结果。
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            log.error("supplyAsyncGet error.");
        }
        return result;
    }

    private static String getFutureResult(CompletableFuture<String> completableFuture, int timeout) {
        String result = null;
        try {
            //获取返回值，2秒超时
            result = completableFuture.get(timeout, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error("InterruptedException error.", e);
        } catch (ExecutionException e) {
            log.error("ExecutionException error.", e);
        } catch (TimeoutException e) {
            log.error("TimeoutException error.", e);
        }
        return result;
    }


}
