package Thread.Executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author GocChin
 * @Date 2021/7/26 10:27
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description: 延迟查询  在给定的延迟时间后执行命令，或者定期执行命令  能够保证顺序 ， 数量固定
 *
 *  ScheduledThreadPoolExecutor具有固定线程个数，适用于需要多个后台线程执行周期任务，并且为了满足资源管理需求而限制后台线程数量的场景
 * 它适用于单个后台线程执行周期任务，并且保证顺序一致执行的场景。
 *
 */
public class ScheduledThreadPoolTest {
    public static void main(String[] args) {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(3);
        //创建线程
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        Thread t3 = new MyThread();
        Thread t4 = new MyThread();
        Thread t5 = new MyThread();
        pool.execute(t1);
        pool.execute(t2);
        //使用延迟执行风格的方法
        pool.schedule(t2,1000, TimeUnit.MILLISECONDS);
        pool.schedule(t3,1000,TimeUnit.MILLISECONDS);
        // 关闭线程池
        pool.shutdown();
    }

}
