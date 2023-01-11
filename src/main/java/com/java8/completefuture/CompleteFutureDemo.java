package com.java8.completefuture;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.concurrent.*;


public class CompleteFutureDemo {

    private static Logger logger= LogManager.getLogger(CompleteFutureDemo.class);

    public static void main(String[] args) {
        supplyAsyncGet();
    }

    public static void supplyAsyncGet()  {
        //该线程池仅用于示例，实际建议使用自定义的线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()
                -> runTask(), executorService);

        String result = null;
        try {
            //获取返回值，2秒超时
            result = completableFuture.get(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            logger.error("InterruptedException error.", e);
        } catch (ExecutionException e) {
            logger.error("ExecutionException error.", e);
        } catch (TimeoutException e) {
            logger.error("TimeoutException error.", e);
        }
        logger.info("result:"+result);
    }

    private static String runTask() {
        try {
            //任务耗时。可以分别设置1000和3000，看未超时和超时的不同结果。
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            logger.error("supplyAsyncGet error.");
        }
        return "supplyAsyncGet";
    }
}
