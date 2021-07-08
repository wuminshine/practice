package com.example.demo.spring.beans.factory;

import java.lang.reflect.Constructor;

/**
 * 实例化对象接口
 */
public interface InstantiationStrategy {

    /**
     * 根据构造器实例化对象
     * @param beanDefinition
     * @param beanName
     * @param constructor
     * @param args
     * @return
     */
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args) throws Exception;
}
