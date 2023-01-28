package com.thread.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Slf4j
public class SubmitDemo {
    public static void main(String[] args)  {
        submit();
    }

    public static void submit()  {
        long start = System.currentTimeMillis();
        //该线程池仅用于示例，实际建议使用自定义的线程池
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<String> future1 = executor.submit(() -> {
            Thread.sleep(4000);
            return "task1";
        });
        Future<String> future2 = executor.submit(() -> {
            Thread.sleep(5000);
            return "task2";
        });

        List<String> resultList = new ArrayList<>();
        addFutureResult(future1, resultList, 2,"add result1 error.");

        addFutureResult(future2, resultList,  2, "add result2 error.");

        System.out.println("it cost time :"+ (System.currentTimeMillis()-start) );
        resultList.forEach(System.out::println);
    }

    private static void addFutureResult(Future<String> future, List<String> resultList, int timeout, String s) {
        try {
            String result = future.get(timeout, TimeUnit.SECONDS);
            resultList.add(result);
        } catch (Exception e) {
            log.error(s, e);
        }
    }

}
