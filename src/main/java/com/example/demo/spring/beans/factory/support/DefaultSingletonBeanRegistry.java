package com.example.demo.spring.beans.factory.support;

import com.example.demo.spring.beans.factory.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * 单例对象获取实现类
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    Map<String, Object> singleInstanceMap = new HashMap<>();

    /**
     * 获取单例对象
     * @param beanName
     * @return
     */
    @Override
    public Object getSingleton(String beanName) {
        return singleInstanceMap.get(beanName);
    }

    /**
     * 缓存单例对象
     * @param beanName
     * @param instance
     */
    public void addSingleton(String beanName, Object instance)
    {
        singleInstanceMap.put(beanName, instance);
    }
}
