package com.retry;


import org.apache.log4j.Logger;

import java.util.Random;

/**
 * 重试
 *
 * 服务不稳定的时候，可以重试。
 *
 */
public class RetryDemo {
    private static final Logger log = Logger.getLogger(RetryDemo.class.getName());

    public static void main(String[] args) throws InterruptedException {
        retryDoSomething();
    }

    public static void retryDoSomething() throws InterruptedException {
        log.info("retryDoSomething start.");
        //重试次数
        int maxTimes = 5;
        //每次重试间隔时间
        int interval = 500;

        for (int i = 0; i <= maxTimes; i++) {
            boolean isOk = doSomething();
            //成功了就停止
            if (isOk ) {
                break;
            }
            //失败就间隔一段时间后再执行
            Thread.sleep(interval);
        }
        log.info("retryDoSomething end.");
    }


    /**
     * 执行逻辑，成功就返回 true，报错返回 false
     *
     * @return
     */
    public static boolean doSomething() {
        try {
            //执行逻辑
            doSth();
        } catch (Exception e) {
            log.error("service.doSomething() error.", e);
            return false;
        }
        return true;
    }

    /**
     * 执行逻辑的方法
     *
     * 以下是示例,可以将示例替换成自己的逻辑
     *
     */
    private static void doSth() {
        Random random = new Random();
        //随机产生一个[0-100]之间的随机数，由于是随机，每次执行的结果可能不一样
        int num = random.nextInt(101);
        if (num % 5 ==0) {
            log.info("doSth num:"+ num);
        } else {
            //模拟失败，抛异常
            throw new NumberFormatException();
        }

    }
}
