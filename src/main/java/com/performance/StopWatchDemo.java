package com.performance;

import org.springframework.util.StopWatch;

public class StopWatchDemo {

    public static void main(String[] args) throws InterruptedException {
        stopWatch();
    }


    public static void stopWatch() throws InterruptedException {
        StopWatch stopWatch = new StopWatch("myStopWatch");

        stopWatch.start("任务1");
        Thread.sleep(2000);
        stopWatch.stop();

        stopWatch.start("任务2");
        Thread.sleep(1000);
        stopWatch.stop();

        System.out.println("总耗时以及各个任务耗时如下：\n");
        System.out.println(stopWatch.prettyPrint());
        System.out.println("总耗时："+ stopWatch.getTotalTimeMillis());
        System.out.println("最后一个任务的线程名称："+ stopWatch.getLastTaskName());



    }


}
