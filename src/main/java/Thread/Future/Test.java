package Thread.Future;

import java.util.concurrent.Executors;

/**
 * @Author GocChin
 * @Date 2021/7/26 11:04
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();

        // 等凉菜 -- 必须要等待返回的结果，所以要调用join方法
        Thread t1 = new ColdDishThread();
        t1.start();
        t1.join(); //等待线程终止

        // 等包子 -- 必须要等待返回的结果，所以要调用join方法
        Thread t2 = new BumThread();
        t2.start();
        t2.join(); //等待线程终止
        long end = System.currentTimeMillis();
        System.out.println("准备完毕时间："+(end-start));
    }
}
