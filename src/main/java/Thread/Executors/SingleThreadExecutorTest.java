package Thread.Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author GocChin
 * @Date 2021/7/26 10:19
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:  单任务线程 保证顺序，不存在多线程活动
 *          等于说都只调用了 Thread 1  的方法
 */
public class SingleThreadExecutorTest {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newSingleThreadExecutor();
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
