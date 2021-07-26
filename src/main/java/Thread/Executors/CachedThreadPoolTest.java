package Thread.Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author GocChin
 * @Date 2021/7/26 10:21
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:  可变尺度线程 适用于执行很多短期异步任务的小程序，适用于负载较轻的服务器  顺序可能发生变化
 */
public class CachedThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        //创建线程
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        Thread t3 = new MyThread();
        Thread t4 = new MyThread();
        Thread t5 = new MyThread();
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);
        // 关闭线程池
        pool.shutdown();
    }
}
