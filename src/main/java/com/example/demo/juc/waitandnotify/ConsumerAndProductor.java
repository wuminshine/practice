package com.example.demo.juc.waitandnotify;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;

public class ConsumerAndProductor {

    // 放消息的队列
    static List<Integer> queue = new ArrayList<>(10);

    public static void main(String[] args) {
        Object lock = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true)
                {
                    synchronized (lock)
                    {
                        while(queue.size() == 10)
                        {
                            try {
                                lock.wait();
                                lock.notifyAll();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        if (queue.size() < 10)
                        {
                            Integer randomInt = new Random().nextInt();
                            queue.add(randomInt);
                            System.out.println("生产者线程生产了：" + randomInt);
                            lock.notifyAll();
                        }
                    }
                }
            }
        }, "生产者线程").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true)
                {
                    synchronized (lock)
                    {
                        while(queue.size() == 0)
                        {
                            try {
                                lock.wait();
                                lock.notifyAll();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        if (queue.size() != 0 )
                        {
                            Integer removeInt = queue.remove(0);
                            System.out.println("消费者线程消费了：" + removeInt);
                            lock.notifyAll();
                        }
                    }
                }
            }
        }, "消费者线程").start();
    }
}
