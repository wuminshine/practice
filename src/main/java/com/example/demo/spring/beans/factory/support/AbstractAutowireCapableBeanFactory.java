package com.example.demo.spring.beans.factory.support;

import com.example.demo.spring.beans.factory.BeanDefinition;

/**
 * 定义创建bean的公共行为
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    /**
     * 先判断是否有缓存的单例对象，有就直接返回，否则通过反射创建实例
     * @param beanName
     * @param beanDefinition
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    @Override
    Object createBean(String beanName, BeanDefinition beanDefinition) throws IllegalAccessException, InstantiationException {
        Object singletonInstance = getSingleton(beanName);
        if (singletonInstance != null)
        {
            return singletonInstance;
        }
        Object instance = beanDefinition.getBeanClass().newInstance();
        addSingleton(beanName, instance);
        return instance;
    }
}
