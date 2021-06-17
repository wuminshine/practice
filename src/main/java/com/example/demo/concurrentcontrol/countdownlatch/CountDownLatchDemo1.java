package com.example.demo.concurrentcontrol.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 演示CountDownLatch一等多的场景
 *  等待5个人全部到齐之后，再开始就餐。
 */
public class CountDownLatchDemo1 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            int threadNo = i + 1;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep((long) ((Math.random())*10000));
                        System.out.println("Thread" + threadNo + "到位！");
                        countDownLatch.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        System.out.println("等待开饭~~~");
        countDownLatch.await();
        System.out.println("所有人员到齐，开饭啦~~~~~~");
//        System.out.println(new Random().);

    }
}
