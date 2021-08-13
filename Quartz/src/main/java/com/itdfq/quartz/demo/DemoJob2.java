package com.itdfq.quartz.demo;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @Author: GodChin
 * @Date: 2021/8/12 14:23
 * @Blog: http://itdfq.com
 * @QQ: 909256107
 * @Description:
 */
public class DemoJob2 implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDetail detail = context.getJobDetail();
        Object city = detail.getJobDataMap().get("city");
        System.out.println("执行第二个调度器");
        System.out.println("获取到的值为："+city);



    }
}
