package com.example.demo.juc.exception;

public class ThreadThrowException {

    public static void main(String[] args) {
        try
        {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    throw new NullPointerException();
                }
            }).start();
        }
        catch(Exception e)
        {
            System.out.println("外层打印异常...");
            System.out.println(e);
        }
    }
}
