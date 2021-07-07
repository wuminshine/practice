package com.example.demo.spring.beans.factory;

/**
 * 获取单例对象接口
 */
public interface SingletonBeanRegistry {
   Object getSingleton(String beanName);
}
