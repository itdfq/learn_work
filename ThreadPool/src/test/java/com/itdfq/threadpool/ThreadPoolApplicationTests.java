package com.itdfq.threadpool;

import com.itdfq.threadpool.pool.MyTask;
import com.itdfq.threadpool.pool.ThreadPoolUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ThreadPoolApplicationTests {

    @Autowired
    private ThreadPoolUtils pool;
    @Test
    void contextLoads() {
        pool.submit(new MyTask( "任务1"));
        pool.submit(new MyTask( "任务2"));
        pool.submit(new MyTask( "任务3"));
        pool.submit(new MyTask( "任务4"));
        pool.submit(new MyTask( "任务5"));
        pool.submit(new MyTask( "任务6"));
        pool.submit(new MyTask( "任务7"));
        pool.submit(new MyTask( "任务8"));
    }

}
