package com.itdfq.zookeeper;

import com.itdfq.zookeeper.config.ZkApi;
import com.itdfq.zookeeper.lock.Ticket;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest
@Slf4j
class ZookeeperApplicationTests {

    @Autowired
    private ZkApi zkApi;


    @Test
    void contextLoads() throws Exception {
        InterProcessMutex lock = zkApi.getLock("lock");
        System.out.println(lock.acquire(3, TimeUnit.SECONDS));
    }


    @Test
    public void getZkValue() {
        String sum = zkApi.getZkValue("sum");
        System.out.println(sum);
    }

    @Test
    public void set() throws Exception {
        zkApi.setZkValue("project.name", "spring.application.name=Zookeeper123更新数据");
    }


    //抢票
    @Test
    public void buyTicket() {


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
               buy(2);
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                buy(1);
            }
        });
        thread.start();
        thread1.start();
    }

    @Test
    public void buy1() {
        buy(1);
        buy(2);
    }

    public void buy(Integer name) {
        InterProcessMutex lock = zkApi.getLock("lock");
        try {
            boolean acquire = lock.acquire(3, TimeUnit.SECONDS);
            if (acquire) {
                String sum = zkApi.getZkValue("sum");
                int anInt = Integer.parseInt(sum);
                if (anInt<1){
                    System.out.println("当前线程：" + Thread.currentThread().getName() + "---" + "票数不足"+ "购买后票数：" + anInt);
                    return;
                }
                anInt = anInt - 1;
                zkApi.setZkValue("sum", String.valueOf(anInt));
                System.out.println("当前线程：" + Thread.currentThread().getName() + "---" + "购买人：同学"
                        + name + "购买前票数：" + sum + "购买后票数：" + anInt);
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    log.error("休眠异常");
                }
            }

        } catch (Exception e) {
            log.error("获取锁失败", e);
            return;
        } finally {
            try {
                lock.release();
            } catch (Exception e) {
                log.error("释放锁失败", e);
            }
        }


    }

    @Test
    public void thread() {
        Thread thread = new Thread(new Ticket("买票人：" + 123));
        //start方法方可启动线程，而run方法只是thread的一个普通方法调用，还是在主线程里执行
        thread.run();//当前线程：main---------买票人：123买票
        thread.start();//当前线程：Thread-3---------买票人：123买票
    }


}
