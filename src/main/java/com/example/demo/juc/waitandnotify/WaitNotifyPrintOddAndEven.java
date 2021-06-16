package com.example.demo.juc.waitandnotify;

public class WaitNotifyPrintOddAndEven {
    static int i = 0;
    static Object lock = new Object();

    public static void main(String[] args) {
        new Thread(new PrintOddAndEven(), "偶数线程").start();
        new Thread(new PrintOddAndEven(), "奇数线程").start();
    }

    public static class PrintOddAndEven implements Runnable
    {

        @Override
        public void run() {
            while (i <= 100)
            {
                synchronized (lock)
                {
                    // 先自己打印，再唤醒其他线程打印，交替打印
                    System.out.println(Thread.currentThread().getName() + ":" + i++);
                    lock.notify();

                    if(i <= 100)
                    {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
