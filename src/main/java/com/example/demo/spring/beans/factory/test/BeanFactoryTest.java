package com.example.demo.spring.beans.factory.test;

import com.example.demo.spring.beans.factory.BeanDefinition;
import com.example.demo.spring.beans.factory.support.DefaultListableBeanFactory;

public class BeanFactoryTest {

    public static void main(String[] args) throws Exception {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        defaultListableBeanFactory.registerBeanDefinition("testBean", new BeanDefinition(TestBean.class));
        TestBean testBean = (TestBean)defaultListableBeanFactory.getBean("testBean", "Jack");
        testBean.doSomething();
//        TestBean testBean2 = (TestBean)defaultListableBeanFactory.getBean("testBean");
//        testBean2.doSomething();
    }
}
