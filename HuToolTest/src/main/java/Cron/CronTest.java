package Cron;

import cn.hutool.core.lang.Console;
import cn.hutool.cron.CronUtil;
import cn.hutool.cron.task.Task;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: GodChin
 * @Date: 2021/8/16 13:45
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description: 全局定时任务
 */
@Slf4j
public class CronTest {
    public static void main(String[] args) {
        CronUtil.schedule("*/2 * * * * *", new Task() {
            @Override
            public void execute() {
                Console.log("Task excuted.");
            }
        });

// 支持秒级别定时任务
        CronUtil.setMatchSecond(true);
        CronUtil.start();
    }
}
