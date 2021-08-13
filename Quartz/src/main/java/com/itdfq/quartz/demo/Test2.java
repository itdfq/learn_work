package com.itdfq.quartz.demo;


import static org.quartz.DateBuilder.newDate;
import static org.quartz.JobBuilder.newJob;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import org.quartz.Trigger;

import static org.quartz.TriggerBuilder.newTrigger;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.AnnualCalendar;

import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: GodChin
 * @Date: 2021/8/12 13:48
 * @Blog: http://itdfq.com
 * @QQ: 909256107
 * @Description:
 */
public class Test2 {
    public static void main(String[] args) throws SchedulerException {
        try {
            //创建scheduler
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            /**
             * HolidayCalendar。指定特定的日期，比如20140613。精度到天。
             * DailyCalendar。指定每天的时间段（rangeStartingTime, rangeEndingTime)，格式是HH:MM[:SS[:mmm]]。也就是最大精度可以到毫秒。
             * WeeklyCalendar。指定每星期的星期几，可选值比如为java.util.Calendar.SUNDAY。精度是天。
             * MonthlyCalendar。指定每月的几号。可选值为1-31。精度是天
             * AnnualCalendar。 指定每年的哪一天。使用方式如上例。精度是天。
             * CronCalendar。指定Cron表达式。精度取决于Cron表达式，也就是最大精度可以到秒。
             * 可以选择排除 也可以指定是选择的日期
             */
            AnnualCalendar cal = new AnnualCalendar(); //定义一个每年执行Calendar，精度为天，即不能定义到2.25号下午2:00
            java.util.Calendar excludeDay = new GregorianCalendar();
            excludeDay.setTime(newDate().inMonthOnDay(2, 25).build());
            cal.setDayExcluded(excludeDay, true);  //设置排除2.25这个日期
            scheduler.addCalendar("FebCal", cal, false, false); //scheduler加入这个Calendar

            //定义一个Trigger
            Trigger trigger = newTrigger().withIdentity("trigger1", "group1") //定义name/group
                    .startNow()//一旦加入scheduler，立即生效
                    .modifiedByCalendar("FebCal")   //排除每年的2.25  下午2：00
                    .withSchedule(simpleSchedule() //使用SimpleTrigger
                            .withIntervalInSeconds(1) //每隔一秒执行一次
                            .repeatForever()) //一直执行，奔腾到老不停歇
                    .build();


            //定义一个JobDetail
            JobDetail job = newJob(DemoJob.class) //定义Job类为DemoJob，这是真正的执行逻辑所在
                    .withIdentity("job1", "group1") //定义name/group
                    .usingJobData("name", "quartz") //定义属性
                    .build();
//            //在定义一个JobDetail
            JobDetail job1 = newJob(DemoJob2.class) //定义Job类为DemoJob，这是真正的执行逻辑所在
                    .withIdentity("job2", "group1") //定义name/group
                    .usingJobData("city", "杭州") //定义属性
                    .build();
            //加入这个调度
//            scheduler.scheduleJob(job, trigger);
            Map<JobDetail, Set<Trigger>> map = new HashMap<>();
            Set<Trigger> set = new HashSet<>();
            set.add(trigger);
            map.put(job, set);
            map.put(job1,set);
            scheduler.scheduleJobs(Collections.unmodifiableMap(map),true);

//            //测试加入两个
//            scheduler.scheduleJob(job1,trigger);

            //启动之
            scheduler.start();

            //运行一段时间后关闭
            Thread.sleep(10000);
            scheduler.shutdown(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
