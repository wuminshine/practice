package com.example.demo.spring.beans.factory.test;

import com.example.demo.spring.beans.core.io.DefaultResourceLoader;
import com.example.demo.spring.beans.core.io.Resource;
import com.example.demo.spring.beans.core.io.ResourceLoader;
import com.example.demo.spring.beans.factory.support.DefaultListableBeanFactory;
import com.example.demo.spring.beans.factory.xml.XmlBeanDefinitionReader;

public class BeanFactoryTest {

    public static void main(String[] args) throws Exception {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("classpath:spring.xml");
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        xmlBeanDefinitionReader.loadBeanDefinitions(resource);
        UserService userService = (UserService)defaultListableBeanFactory.getBean("userService");
//        System.out.println(userService.getUser("2"));
        System.out.println(userService.getUser());
    }
}
