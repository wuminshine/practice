package com.example.demo.concurrentcontrol.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 信号量的简单使用
 *  10个人排队吃饭，有3张椅子，1个人吃完就让出椅子，让后来的人坐椅子吃饭
 */
public class SemaphoreDemo1 {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3, true);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            int peopleNo = i + 1;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println("吃货" + peopleNo + "获得椅子吃饭！！！");
                        Thread.sleep((long) (Math.random()*1000));
//                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    finally {
                        System.out.println("吃货" + peopleNo + "吃完了，放回椅子！！！");
                        semaphore.release();
                    }
                }
            });
//            Thread thread = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        semaphore.acquire();
//                        Thread.sleep((long) (Math.random()*10000));
//                        System.out.println("吃货" + peopleNo + "获得椅子吃饭！！！");
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    finally {
//                        semaphore.release();
//                        System.out.println("吃货" + peopleNo + "吃完了，放回椅子！！！");
//                    }
//                }
//            });
//            thread.start();
        }
    }



//    static Semaphore semaphore = new Semaphore(3, true);
//
//    public static void main(String[] args) {
//        ExecutorService service = Executors.newFixedThreadPool(50);
//        for (int i = 0; i < 10; i++) {
//            service.submit(new Task());
//        }
//        service.shutdown();
//    }
//
//    static class Task implements Runnable {
//
//        @Override
//        public void run() {
//            try {
//                semaphore.acquire(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + "拿到了许可证");
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + "释放了许可证");
//            semaphore.release(1);
//        }
//    }
}
