package Thread.pool;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: QianMo
 * @Date: 2021/10/22 14:33
 * @Description:
 */
public class Demo2 {
    public static void main(String[] args) {


        //CPU 个数
        System.out.println(Runtime.getRuntime().availableProcessors());
//        ExecutorService executor = new ThreadPoolExecutor(1, 1,
//                1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1)){
            ExecutorService executor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1)) {
                @Override protected void beforeExecute(Thread t, Runnable r) {
                    System.out.println("任务执行前 is called");
                }
                @Override protected void afterExecute(Runnable r, Throwable t) {
                    System.out.println("任务执行后 is called");
                }
                @Override protected void terminated() {
                    System.out.println("线程池结束后 is called");
                }
            };

        executor.execute(()->System.out.println("124"));
        executor.shutdown();


    }
}
