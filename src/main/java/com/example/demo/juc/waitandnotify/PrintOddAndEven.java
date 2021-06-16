package com.example.demo.juc.waitandnotify;

public class PrintOddAndEven {
    static int i = 0;

    public static void main(String[] args) {
        Object lock = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (lock) {
                        // 判断是偶数
                        if (i % 2 == 0 && i <= 100) {
                            System.out.println(Thread.currentThread().getName() + "打印偶数：" + i++);
                        }
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (lock) {
                        // 判断是偶数
                        if (i % 2 == 1 && i <= 100) {
                            System.out.println(Thread.currentThread().getName() + "打印奇数：" + i++);
                        }
                    }
                }
            }
        }).start();
    }
}
