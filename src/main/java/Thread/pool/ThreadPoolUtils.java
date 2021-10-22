package Thread.pool;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: QianMo
 * @Date: 2021/10/22 15:43
 * @Description:
 * SpringBoot搭配@Component使用
 */

@Slf4j
public class ThreadPoolUtils {

    private ExecutorService executorService;

    private static final AtomicInteger FAIL_COUNT = new AtomicInteger(1);

    @PostConstruct
    public void init() {
        executorService = new ThreadPoolExecutor(1,
                2,
                60,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(3)
                , Executors.defaultThreadFactory()
                , new MyRejected());
    }


    class MyRejected implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

            log.error("线程报警信息：{}，没有被执行,拒绝次数：{}", executor.getActiveCount(), FAIL_COUNT);
            //可以往消息队列中间件里面放 可以发Email等等
        }

    }

    public  void submit(Runnable runnable) {
        try {
            Future<?> submit = executorService.submit(runnable);
            log.info("线程执行结果：{}", submit.get());
        } catch (Exception e) {
            log.error("线程执行异常", e);
        } finally {
            executorService.shutdown();
        }
    }

}


