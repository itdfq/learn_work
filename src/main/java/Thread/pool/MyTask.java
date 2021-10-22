package Thread.pool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @Author: QianMo
 * @Date: 2021/10/22 16:01
 * @Description:
 */
@Slf4j
public class MyTask implements Runnable {

    /**
     * 任务id
     */
    private int taskId;

    /**
     * 任务名字
     */
    private String taskName;

    public MyTask(int taskId, String taskName) {
        this.taskId = taskId;
        this.taskName = taskName;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println("任务ID:" + this.taskId + "任务名字" + this.taskName);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            log.error("休眠异常", e);
        }
    }
}
