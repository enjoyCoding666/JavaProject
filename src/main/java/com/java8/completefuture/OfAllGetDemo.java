package com.java8.completefuture;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public class OfAllGetDemo {

    private static Logger logger= LogManager.getLogger(OfAllGetDemo .class);

    public static void main(String[] args) {
        allOfGet();
    }


    /**
     *  异步，多任务。汇总返回值
     */
    public static void allOfGet()  {
        //该线程池仅用于示例，实际建议使用自定义的线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        String word1 = "word1";
        String word2 = "word2";

        //线程安全的list，适合写多读少的场景
        List<String> strList = Collections.synchronizedList(new ArrayList<>(50));
        CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(
                () -> getResult(word1, 1000), executorService)
                .whenComplete((result, throwable) -> {
                    //任务完成时执行
                    if (result != null) {
                        strList.add(result);
                    }
                    if (throwable != null) {
                        logger.error("completableFuture1  error:{}", throwable);
                    }
                });

        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(
                () -> getResult(word2, 1500), executorService)
                .whenComplete((result, throwable) ->{
                    if (result != null) {
                        strList.add(result);
                    }
                    if (throwable != null) {
                        logger.error("completableFuture2  error:{}", throwable);
                    }

                });

        List<CompletableFuture<String>> futureList = new ArrayList<>();
        futureList.add(completableFuture1);
        futureList.add(completableFuture2);

        try  {
            //多个任务，耗时不超时2秒
            CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0]))
                    .get(2, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException e) {
            logger.error("CompletableFuture.allOf InterruptedException error.", e);
        } catch (TimeoutException e) {
            logger.error("CompletableFuture.allOf TimeoutException error.", e);
        }
        List<String> resultList = new ArrayList<>(strList);

        resultList.forEach(System.out::println);
    }


    private static String getResult(String result, int millis) {
        try {
            //任务耗时。可以分别设置1000和3000，看未超时和超时的不同结果。
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            logger.error("supplyAsyncGet error.");
        }
        return result;
    }
}
