package com.example.demo.juc.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 手写一个线程池
 */
public class MyThreadPool {

    /**
     * 对线程数量进行计数，AtomicInteger保证原子性
     */
    private AtomicInteger ctl = new AtomicInteger(0);

    /**
     * 核心线程数
     */
    private int coreThreadNum;

    /**
     * 最大线程数
     */
    private int maxThreadNum;

    /**
     * 消息队列
     */
    private ArrayBlockingQueue<Runnable> queue;

    /**
     * 构造函数
     * @param coreThreadNum 核心线程数
     * @param maxThreadNum 最大线程数
     * @param queue 消息队列
     */
    public MyThreadPool(int coreThreadNum, int maxThreadNum, ArrayBlockingQueue<Runnable> queue) {
        this.coreThreadNum = coreThreadNum;
        this.maxThreadNum = maxThreadNum;
        this.queue = queue;
    }

    public void execute(Runnable task)
    {
        // 先判断线程数量是否小于核心线程数量，若小于，则创建核心线程
        int num = ctl.get();
        if (num < coreThreadNum)
        {
            if(!addWorker(task))
            {
                reject();
            }
            return;
        }
        if (!queue.offer(task))
        {
            if (!addWorker(task))
            {
                reject();
            }
        }
    }

    private void reject() {
        System.out.println("************任务被拒绝了");
    }

    /**
     * 创建worker对象
     * @param task
     */
    private boolean addWorker(Runnable task) {
        // 判断 线程数量
        if (ctl.get() >= maxThreadNum)
            return false;
        Worker worker = new Worker(task);
        worker.thread.start();
        ctl.incrementAndGet();
        return true;
    }

    class Worker implements Runnable{

        Thread thread;
        Runnable firstTask;

        public Worker(Runnable task) {
            this.thread = new Thread(this);
            this.firstTask = task;
        }

        @Override
        public void run() {
            Runnable task = firstTask;
            try {
                while (task != null || (task = getTask())!= null)
                {
                    task.run();
                    if (ctl.get() > maxThreadNum)
                    {
                        break;
                    }
                    task = null;
                }
            }
            finally {
                ctl.decrementAndGet();
            }

        }

        // 从消息队列中拿消息
        private Runnable getTask() {
            while (true)
            {
                try {
                    System.out.println("队列的消息长度：" + queue.size());
                    return queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
