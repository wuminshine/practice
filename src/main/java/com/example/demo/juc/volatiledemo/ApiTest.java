package com.example.demo.juc.volatiledemo;

//public class ApiTest {
//
//    public static void main(String[] args) {
//        SignRunnable signRunnable = new SignRunnable();
//        Thread thread1 = new Thread(signRunnable);
//        Thread thread2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                signRunnable.isRun = false;
//                System.out.println("将signRunnable 的iSRun 设置为 false");
//            }
//        });
//        thread1.start();
//        thread2.start();
//    }
//
//
//}
//
//class SignRunnable implements Runnable{
//
//    public boolean isRun = true;
//
//    @Override
//    public void run() {
//        while(isRun)
//        {
//
//        }
//        System.out.println("SignRunnable 执行结束");
//    }
//}
public class ApiTest {
    public static void main(String[] args) {
        final VT vt = new VT();
        Thread Thread01 = new Thread(vt);
        Thread Thread02 = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ignore) {
                }
                vt.sign = false;
                System.out.println("vt.sign = true 通知 while (!sign) 结束！ ");
            }
        });
        Thread01.start();
        Thread02.start();
    }
}
class VT implements Runnable {
    public boolean sign = true;
    int i = 0;
    public void run() {
        while (sign) {
            synchronized (new Object())
            {
                i++;
            }
        }
        System.out.println("你坏");
    }
}
