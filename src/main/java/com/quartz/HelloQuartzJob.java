package com.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

public class HelloQuartzJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("Hello,Quartz!----executing its Job at "+
        new Date()+" by "+ jobExecutionContext.getTrigger().getKey().getName());
    }
}
