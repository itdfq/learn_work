package com.itdfq.threadpool.pool;

/**
 * @Author: QianMo
 * @Date: 2021/10/22 16:41
 * @Description:
 */
public class MyTask extends ThreadBase {

    public MyTask(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("线程：" + getName() + "执行了");
    }
}
