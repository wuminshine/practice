package com.example.demo.juc.threadpool;

import java.util.concurrent.ArrayBlockingQueue;

public class MyThreadPoolTest {
    public static void main(String[] args) {
        MyThreadPool threadPool = new MyThreadPool(2, 5, new ArrayBlockingQueue<Runnable>(10));
        for (int i = 0; i < 15; i++) {
            int finalI = i;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("任务" + finalI + "执行");
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
