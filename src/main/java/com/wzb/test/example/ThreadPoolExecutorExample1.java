package com.wzb.test.example;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author Administrator
 * @Date 2022/8/22 0022 16:56
 */
@Slf4j
public class ThreadPoolExecutorExample1 {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor poolExecutorB = new ThreadPoolExecutor(5, 5, 3, TimeUnit.MINUTES, new ArrayBlockingQueue<>(10));

        for (int i = 0; i < 12; i++) {
            int finalI = i;
            boolean b = poolExecutorB.getActiveCount() == 5;
            while (b) {
                Thread.sleep(1000);
                b = poolExecutorB.getActiveCount() == 5;
                log.error(""+ poolExecutorB.getActiveCount());
            }

            poolExecutorB.execute(() -> {
                log.info(String.valueOf(finalI));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

        }

    }
}
