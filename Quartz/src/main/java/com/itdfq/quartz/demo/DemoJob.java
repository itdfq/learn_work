package com.itdfq.quartz.demo;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;


/**
 * @Author: GodChin
 * @Date: 2021/8/12 13:48
 * @Blog: http://itdfq.com
 * @QQ: 909256107
 * @Description:
 */
public class DemoJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDetail detail = context.getJobDetail();
        System.out.println("JobDetail:"+detail);
        String name = detail.getJobDataMap().getString("name");
        System.out.println("执行此方法----------获取到的名字为："+name);
        System.out.println("say hello to " + name + " at " + new Date());
    }
}
