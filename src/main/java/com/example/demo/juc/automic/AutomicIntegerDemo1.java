package com.example.demo.juc.automic;

import java.util.concurrent.atomic.AtomicInteger;

public class AutomicIntegerDemo1 implements Runnable{

    private static final AtomicInteger atomicInteger = new AtomicInteger();
    private static int basicInt = 0;

    private void increatAtomic()
    {
        atomicInteger.incrementAndGet();
    }

    private synchronized void increatBasic()
    {
        basicInt++;
    }


    @Override
    public void run() {
        for (int i = 0; i < 10000 ; i++) {
            increatAtomic();
            increatBasic();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable target  = new AutomicIntegerDemo1();
        Thread thread1 = new Thread(target);
        Thread thread2 = new Thread(target);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("原子类操作结果：" + atomicInteger.get());
        System.out.println("普通类操作结果：" + basicInt);
    }
}
