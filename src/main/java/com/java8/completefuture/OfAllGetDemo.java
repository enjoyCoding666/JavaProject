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

        //线程安全的list，适合写多读少的场景
        List<String> resultList = Collections.synchronizedList(new ArrayList<>(50));
        CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(
                () -> runTask("result1", 1000), executorService)
                .whenComplete((result, throwable) -> {
                    //任务完成时执行。用list存放任务的返回值
                    if (result != null) {
                        resultList.add(result);
                    }
                    //触发异常
                    if (throwable != null) {
                        logger.error("completableFuture1  error:{}", throwable);
                    }
                });

        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(
                () -> runTask("result2", 1500), executorService)
                .whenComplete((result, throwable) ->{
                    if (result != null) {
                        resultList.add(result);
                    }
                    if (throwable != null) {
                        logger.error("completableFuture2  error:{}", throwable);
                    }

                });

        List<CompletableFuture<String>> futureList = new ArrayList<>();
        futureList.add(completableFuture1);
        futureList.add(completableFuture2);

        try  {
            //多个任务
            CompletableFuture[] futureArray = futureList.toArray(new CompletableFuture[0]);
            //将多个任务，汇总成一个任务，总共耗时不超时2秒
            CompletableFuture.allOf(futureArray).get(2, TimeUnit.SECONDS);
        } catch (Exception e) {
            logger.error("CompletableFuture.allOf Exception error.", e);
        }
        List<String> list = new ArrayList<>(resultList);

        list.forEach(System.out::println);
    }


    private static String runTask(String result, int millis) {
        try {
            //此处忽略实际的逻辑，用sleep代替
            //任务耗时。可以分别设置1000和3000，看未超时和超时的不同结果。
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            logger.error("supplyAsyncGet error.");
        }
        return result;
    }


}
