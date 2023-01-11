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

        //统计耗时
        System.out.println(stopWatch.prettyPrint());
    }


}
