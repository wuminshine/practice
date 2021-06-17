package com.example.demo.concurrentcontrol.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 演示多等一的场景
 * 多个跑步运动员等裁判一枪令下，就开始跑步
 */
public class CountDownLatchDemo2 {
    public static void main(String[] args) throws InterruptedException {
        // 发令枪信号
        CountDownLatch runningSignal = new CountDownLatch(1);
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // 五个运动员全部等待就位
        for (int i = 0; i < 5; i++) {
            int playerNo = i + 1;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("运动员" + playerNo + "已就位！");
                    try {
                        runningSignal.await();
                        System.out.println("运动员" + playerNo + "起跑！");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        // 2秒以后裁判开启发令枪
        Thread.sleep(2000);
        runningSignal.countDown();
        System.out.println("裁判一枪令下，开始比赛~~~~");
    }
}
