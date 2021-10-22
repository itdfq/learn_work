package Thread.pool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: QianMo
 * @Date: 2021/10/22 16:05
 * @Description:
 */
@Slf4j
public class Client {
    public static void main(String[] args) {


        ThreadPoolExecutor pool = new ThreadPoolExecutor(1,
                1,
                60,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(3)
                , Executors.defaultThreadFactory()
                , new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                MyTask m = (MyTask) r;
                System.out.println("线程报警信息：活跃数"+ executor.getActiveCount()+"  "+m.getTaskName()+"没有被执行");
                //可以往消息队列中间件里面放 可以发Email等等
            }
        });

        pool.execute(new MyTask(1, "任务1"));

        System.out.println("活跃的线程数："+pool.getActiveCount() + ",核心线程数：" + pool.getCorePoolSize() + ",线程池大小：" + pool.getPoolSize() + ",队列的大小" + pool.getQueue().size());

        pool.execute(new MyTask(2, "任务2"));

        System.out.println("活跃的线程数："+pool.getActiveCount() + ",核心线程数：" + pool.getCorePoolSize() + ",线程池大小：" + pool.getPoolSize() + ",队列的大小" + pool.getQueue().size());

        pool.execute(new MyTask(3, "任务3"));

        System.out.println("活跃的线程数："+pool.getActiveCount() + ",核心线程数：" + pool.getCorePoolSize() + ",线程池大小：" + pool.getPoolSize() + ",队列的大小" + pool.getQueue().size());

        pool.execute(new MyTask(4, "任务4"));

        System.out.println("活跃的线程数："+pool.getActiveCount() + ",核心线程数：" + pool.getCorePoolSize() + ",线程池大小：" + pool.getPoolSize() + ",队列的大小" + pool.getQueue().size());

        pool.execute(new MyTask(5, "任务5"));

        System.out.println("活跃的线程数："+pool.getActiveCount() + ",核心线程数：" + pool.getCorePoolSize() + ",线程池大小：" + pool.getPoolSize() + ",队列的大小" + pool.getQueue().size());

        pool.execute(new MyTask(6, "任务6"));

        System.out.println("活跃的线程数："+pool.getActiveCount() + ",核心线程数：" + pool.getCorePoolSize() + ",线程池大小：" + pool.getPoolSize() + ",队列的大小" + pool.getQueue().size());

        pool.shutdown();

    }

}
