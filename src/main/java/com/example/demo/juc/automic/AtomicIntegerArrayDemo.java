package com.example.demo.juc.automic;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayDemo implements Runnable {

    private static final AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(10);

    public void increment()
    {
        for (int i = 0; i < atomicIntegerArray.length(); i++) {
            atomicIntegerArray.incrementAndGet(i);
        }
    }

    public void decrement()
    {
        for (int i = 0; i < atomicIntegerArray.length(); i++) {
            atomicIntegerArray.decrementAndGet(i);
        }
    }

    @Override
    public void run() {
        increment();
        decrement();
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[100];
        Runnable task = new AtomicIntegerArrayDemo();
        for (int i = 0; i < threads.length; i++) {
            Runnable target;
            threads[i] = new Thread(task);
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < atomicIntegerArray.length(); i++) {
            System.out.println(atomicIntegerArray.get(i));
        }
    }
}
