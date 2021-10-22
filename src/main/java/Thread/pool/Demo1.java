package Thread.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: QianMo
 * @Date: 2021/10/22 13:57
 * @Description:
 */
public class Demo1 {
    public static void main(String[] args) {

        /***********************等待队列*****************************/


        /**
         * 基于数组实现的等待队列
         * 容量大小   是否FIFO顺序（true:FIFO false:不指定 默认是false）  元素集合
         */
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<Student>(20, false);

        /**
         * 基于链表实现的阻塞队列
         */
        LinkedBlockingQueue<Object> linkedBlockingQueue = new LinkedBlockingQueue<>();

        /**
         * 不存储元素
         * 每个插入操作必须等到另一个线程调用移除操作，否则插入操作将一直处于阻塞状态。
         * 该队列也是Executors.newCachedThreadPool()的默认队列
         */
        SynchronousQueue<Object> synchronousQueue = new SynchronousQueue<>();


        /**
         * 带优先级的无界阻塞队列
         */
        PriorityBlockingQueue<Object> priorityBlockingQueue = new PriorityBlockingQueue<>();


        /***********************线池工厂*****************************/

        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return null;
            }
        };


        /***********************拒绝策略*****************************/

        /**
         * CallerRunsPolicy // 在调用者线程执行
         * AbortPolicy // 直接抛出RejectedExecutionException异常
         * DiscardPolicy // 任务直接丢弃，不做任何处理
         * DiscardOldestPolicy // 丢弃队列里最旧的那个任务，再尝试执行当前任务
         */


        /**
         * 调用者线程执行
         */
        ThreadPoolExecutor.CallerRunsPolicy callerRunsPolicy = new ThreadPoolExecutor.CallerRunsPolicy();


        /**
         *
         corePoolSize – 要保留在池中的线程数，即使它们处于空闲状态，除非设置了allowCoreThreadTimeOut
         maximumPoolSize – 池中允许的最大线程数
         keepAliveTime – 当线程数大于核心数时，这是多余空闲线程在终止前等待新任务的最长时间。
         unit – keepAliveTime参数的时间单位
         workQueue – 用于在执行任务之前保存任务的队列。 这个队列将只保存execute方法提交的Runnable任务。
         threadFactory – 执行程序创建新线程时使用的工厂
         handler – 执行被阻塞时使用的处理程序，因为达到了线程边界和队列容量
         */
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 50L,
                TimeUnit.SECONDS, arrayBlockingQueue, threadFactory, callerRunsPolicy);

        /***********************提交任务的方式*****************************/


        /**
         * execute():适用于提交不需要返回结果的任务
         */
        executor.execute(() -> System.out.println("123"));
    }

}
