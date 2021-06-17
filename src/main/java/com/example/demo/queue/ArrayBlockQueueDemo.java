package com.example.demo.queue;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockQueueDemo {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        Thread thread1 = new Thread(new Interviewer(queue));
        Thread thread2 = new Thread(new Consumer(queue));
        thread1.start();
        thread2.start();
    }

}

class Interviewer implements Runnable
{
    private ArrayBlockingQueue<String> queue;

    public Interviewer(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                String interviewer = "interviewer" + i;
                queue.put(interviewer);
                System.out.println(interviewer + "准备就绪");
            }
            queue.put("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class Consumer implements Runnable{

    private ArrayBlockingQueue<String> queue;

    public Consumer(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            String interviewer = "";
            while (!(interviewer = queue.take()).equals("end")) {
                System.out.println(interviewer + "进行面试");
            }
            System.out.println("面试结束！");
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}