package com.concurrent;

import  java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 *  fork/join框架，fork用于将任务切分成子任务，join用于将子任务的结果汇总。
 */
public class ForkJoinDemo extends RecursiveTask {

        private static final int THRESHOLD= 2;//阈值

        private int start;

        private int end;

        public ForkJoinDemo(int start, int end) {
            this.start= start;
            this.end= end;
        }

       @Override
       protected Integer compute() {
               int sum = 0;
               //如果任务足够小就计算任务
               boolean canCompute = (end-start) <=THRESHOLD;
               if(canCompute) {
                  for(int i =start; i <=end; i++) {
                   sum += i;
                  }
               }else{
               //如果任务大于阀值，就分裂成两个子任务计算
                 int middle = (start+end) / 2;
                 ForkJoinDemo leftTask =new ForkJoinDemo(start, middle);
                 ForkJoinDemo rightTask =new ForkJoinDemo(middle + 1,end);
                 //执行子任务
                 leftTask.fork();
                 rightTask.fork();
                 //等待子任务执行完，并得到其结果
                 int leftResult=(int)leftTask.join();
                 int rightResult=(int)rightTask.join();
                 //合并子任务
                   sum = leftResult  + rightResult;
               }
               return sum;
        }

         public static void main(String[] args) {
               ForkJoinPool forkJoinPool =new ForkJoinPool();
               //生成一个计算任务，负责计算1+2+3+4
               ForkJoinDemo task =new ForkJoinDemo(1, 4);
               //执行一个任务
               Future result = forkJoinPool.submit(task);
               try{
                     System.out.println("计算结果为："+result.get());
                   }catch(InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                 }
         }

        }