package com.itdfq.threadpool.pool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: QianMo
 * @Date: 2021/10/22 16:33
 * @Description:
 */
@Slf4j
@Component
public class ThreadPoolUtils {
    private ExecutorService executorService;

    private static final AtomicInteger count = new AtomicInteger(1);

    @PostConstruct
    public void init() {
        executorService = new ThreadPoolExecutor(1,
                1,
                60,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(2)
                , Executors.defaultThreadFactory()
                , new MyRejected());
    }


    class MyRejected implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            log.error("正在积极执行任务的线程的大致数量:{} 没有被执行,拒绝次数：{}", executor.getActiveCount(), count.getAndIncrement());
            //可以往消息队列中间件里面放 可以发Email等等
        }
    }

    public void submit(Runnable runnable) {
        try {
            executorService.submit(runnable);
        } catch (Exception e) {
            log.error("线程执行异常", e);
        }
    }
}
