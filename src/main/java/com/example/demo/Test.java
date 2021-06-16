package com.example.demo;

import java.lang.reflect.Field;

public class Test {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
//        for (int i = 0; i < 5; i++) {
//            ThreadLocal<Object> threadLocalObj = new ThreadLocal<>();
//            Field threadLocalHashCode = threadLocalObj.getClass().getDeclaredField("threadLocalHashCode");
//            threadLocalHashCode.setAccessible(true);
//            System.out.println(threadLocalHashCode.get(threadLocalObj));
//        }
//        String str = "12345";
//        System.out.println(str.substring(0,1));

        String str_1 = new String("ab");
        String str_2 = new String("ab");
        String str_3 = "ab";
        System.out.println(str_1 == str_2);
        System.out.println(str_1 == str_2.intern());
        System.out.println(str_1.intern() == str_2.intern());
        System.out.println(str_1 == str_3);
        System.out.println(str_1.intern() == str_3);
    }
}
