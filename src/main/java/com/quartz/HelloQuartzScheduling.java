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
public class HelloQuartzScheduling {
    public static void main(String[] args) throws SchedulerException {
        SchedulerFactory schedulerFactory=new StdSchedulerFactory();
        Scheduler scheduler=schedulerFactory.getScheduler();

        JobDetail jobDetail=newJob(HelloQuartzJob.class)
                .withIdentity("helloQuartzJob")
                .build();
        Trigger  trigger=newTrigger()
                   .withIdentity("simpleTrigger")                        // 定义name,这里还可以定义group
                   .withSchedule(    simpleSchedule()
                                     .withIntervalInSeconds(1)         //每隔一秒执行一次
                                     .repeatForever() )               //一直执行，永不停止
                   .startAt( DateBuilder.futureDate(2, DateBuilder.IntervalUnit.SECOND) )       //接下来的两秒执行
                   .build();

        scheduler.scheduleJob(jobDetail  , trigger);
        scheduler.start();

    }
}
