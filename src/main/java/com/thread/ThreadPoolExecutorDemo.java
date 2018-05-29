package com.thread;

import com.bean.LocalUser;
import sun.nio.ch.ThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 参考博客：http://www.cnblogs.com/dolphin0520/p/3932921.html
 */
public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor executor=new ThreadPoolExecutor(5,10,200,
                TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(5));

        for(int i=0;i<15;i++) {
             MyTask myTask=new MyTask(i);
             executor.execute(myTask);
            System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
                    executor.getQueue().size()+"，已执行完别的任务数目："+executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }

    /**
     * 内部类实现Runnable接口，重写run()方法，以此来运用线程。
     */
    static class MyTask implements  Runnable{
        private  int taskNum;

        public MyTask(int taskNum) {
            this.taskNum = taskNum;
        }

        @Override
        public void run() {
            System.out.println("正在执行task"+taskNum);
            try {
                Thread.sleep(4000);

            }catch (InterruptedException e){
                  e.printStackTrace();
            }
            System.out.println("结束执行task"+taskNum);
        }
    }

}
