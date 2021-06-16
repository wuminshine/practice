package com.example.demo.juc.synchronizeddemo;

public class SynchronizedTest {
    static volatile int count = 0;
    public static void main(String[] args) {
        while (true)
        {
            multiThreadAdd();
        }
    }

    public static void multiThreadAdd()
    {
        count = 0;
        for (int i = 0; i < 10; i++) {
//            Runnable target;
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        add();
                    }
                }
            });
            thread.start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (count != 100000)
        {
            System.out.println(count);
        }
    }

    public static void add()
    {
        count++;
    }

//    private static volatile int counter = 0;
//    public static void main(String[] args) throws InterruptedException {
//        for (int i = 0; i < 10; i++) {
//            Thread thread = new Thread(() -> {
//                for (int i1 = 0; i1 < 10000; i1++) {
//                    add();
//                }
//            });
//            thread.start();
//        }
//// 等 10 个线程运行完毕
//        Thread.sleep(1000);
//        System.out.println(counter);
//    }
//    public static void add() {
//        counter++;
//    }
}
