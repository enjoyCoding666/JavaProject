package com.concurrent.threadpool;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * 带有前缀名称的线程工厂
 *
 * 创建线程或线程池时请指定有意义的线程名称，方便出错时回溯。
 */
@Data
@Builder
@AllArgsConstructor
public class ThreadFactoryImpl implements ThreadFactory {

    /**
     * 线程名前缀
     */
    private final String threadName;

    /**
     * 生成线程编号。AtomicInteger 实现了原子性，保证了高并发下的线程安全
     */
    private final AtomicInteger threadNumber = new AtomicInteger(1);


    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, threadName + threadNumber.getAndIncrement());
    }

}


