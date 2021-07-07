package com.wzb.test;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务  三个关键注解
 * @EnableScheduling // 开启定时任务，标注在启动类上
 * @Component        // 托管给spring，标注在类上
 * @Scheduled        // cron表达式定时，标注在方法上
 */

@Component
public class timedTask {
    /**
     * https://cron.qqe2.com/   在线Cron表达式生成器
     * 0 0 23 * * ? *   每天晚上11点执行
     * 0 0/5 * * * ? *  每5分钟执行一次
     */

    // 添加定时任务
    @Scheduled(cron = "0/5 * * * * ?") // cron 表达式，每五秒执行一次
    public  void doTask(){
        System.out.println("我是定时任务~");
    }


}
