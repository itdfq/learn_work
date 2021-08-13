package Thread.Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author GocChin
 * @Date 2021/7/26 13:08
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:  抢占线程池 传递并发线程数参数    不会保证任务的顺序执行 窃取
 */

public class WorkStealingPoolTest {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newWorkStealingPool(4);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println("JVM可用处理器数："+i);
        //创建线程
        MyRunnable t1 = new MyRunnable();
        MyRunnable t2 = new MyRunnable();
        executorService.execute(t1);
        executorService.execute(t2);
        pool.execute(t1);
        pool.execute(t2);
        executorService.shutdown();
        // 关闭线程池
        pool.shutdown();

    }
}
class MyRunnable implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"运行了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}