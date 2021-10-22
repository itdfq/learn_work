package com.itdfq.threadpool.pool;

/**
 * @Author: QianMo
 * @Date: 2021/10/22 16:35
 * @Description:
 */
public abstract class ThreadBase implements Runnable {
    /**
     * 线程名字
     */
    private String Name;

    public ThreadBase(String name) {
        Name = name;
    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
