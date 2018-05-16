package com.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * 详情参考博客：https://www.cnblogs.com/drift-ice/p/3817269.html
 *
 */
public class QuartzScheduling {
    public static void main(String[] args) throws SchedulerException, InterruptedException {
        SchedulerFactory schedulerFactory=new StdSchedulerFactory();
        //创建scheduler，也即调度器
        Scheduler scheduler=schedulerFactory.getScheduler();
        //定义一个JobDetail,定义的是任务数据，而真正的执行逻辑是在Job中
        JobDetail jobDetail=newJob(QuartzJob.class)
                .withIdentity("QuartzJob")
                .build();
        //定义一个Trigger，也就是定义触发的条件。
        Trigger  trigger=newTrigger()
                   .withIdentity("simpleTrigger")                        // 定义name,这里还可以定义group
                   .withSchedule(    simpleSchedule()
                                     .withIntervalInSeconds( 2 )         //每隔30*60 秒,也就是半小时执行一次
                                     .repeatForever() )               //一直执行，永不停止
                   .startAt( DateBuilder.futureDate(2, DateBuilder.IntervalUnit.SECOND )  )     //接下来的两秒执行
                  .build();
        // 把任务和触发器注册到任务调度器中
        scheduler.scheduleJob(jobDetail  , trigger);
        //启动任务调度器
        scheduler.start();
        //运行一段时间后关闭
        Thread.sleep(10*1000);
        scheduler.shutdown(true);
    }
}
