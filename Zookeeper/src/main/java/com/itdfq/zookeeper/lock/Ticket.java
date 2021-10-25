package com.itdfq.zookeeper.lock;

import com.itdfq.zookeeper.config.ZkApi;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

/**
 * @Author: QianMo
 * @Date: 2021/10/25 15:25
 * @Description:
 */
@Slf4j
public class Ticket implements Runnable {

    @Autowired
    private ZkApi zkApi;

    private String name;

    public Ticket(String name) {
        this.name = name;
    }

    @Override
    public void run() {

        InterProcessMutex lock = zkApi.getLock("lock");
        try {
            boolean acquire = lock.acquire(3, TimeUnit.SECONDS);
            if (acquire) {
                String sum = zkApi.getZkValue("sum");
                int anInt = Integer.parseInt(sum);
                anInt = anInt - 1;
                zkApi.setZkValue("sum", String.valueOf(anInt));
                System.out.println("当前线程：" + Thread.currentThread().getName() + "---" + "购买人：同学"
                        + name + "购买前票数：" + sum + "购买后票数：" + anInt);
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

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            log.error("休眠异常");
        }
    }
}
