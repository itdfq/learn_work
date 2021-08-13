package Thread.Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author GocChin
 * @Date 2021/7/26 10:05
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:   数量固定的线程池 顺序可能会发生变化
 */
public class FixedThreadPoolTest {
    public static void main(String[] args) {
        //创建数量固定的线程池
        ExecutorService pool = Executors.newFixedThreadPool(5);
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
