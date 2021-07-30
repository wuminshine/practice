package com.example.demo;

import com.example.demo.spring.beans.factory.BeanFactoryPostProcessor;
import com.example.demo.spring.beans.factory.test.MyBeanPostProcessor;

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

//        String str_1 = new String("ab");
//        String str_2 = new String("ab");
//        String str_3 = "ab";
//        System.out.println(str_1 == str_2);
//        System.out.println(str_1 == str_2.intern());
//        System.out.println(str_1.intern() == str_2.intern());
//        System.out.println(str_1 == str_3);
//        System.out.println(str_1.intern() == str_3);
//        User user = new User();
//        user.setName("ddddd");
//        User user2 = new User();
//        user.setName("ddddd");
////        User user2 = user;
//        User user3 = user;
//        System.out.println(user2.hashCode() == user.hashCode());

        Class beanFactoryPostProcessorClass = BeanFactoryPostProcessor.class;
        Class myBeanPostProcessorClass = MyBeanPostProcessor.class;
        System.out.println(beanFactoryPostProcessorClass.isAssignableFrom(myBeanPostProcessorClass));
        System.out.println(myBeanPostProcessorClass.isAssignableFrom(beanFactoryPostProcessorClass));

    }
}
class User {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
