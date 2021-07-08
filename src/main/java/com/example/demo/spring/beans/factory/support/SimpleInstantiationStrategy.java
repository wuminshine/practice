package com.example.demo.spring.beans.factory.support;

import com.example.demo.spring.beans.factory.BeanDefinition;
import com.example.demo.spring.beans.factory.InstantiationStrategy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * java 反射 实例化对象
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        if(null == constructor)
        {
            return beanDefinition.getBeanClass().newInstance();
        }
        return beanDefinition.getBeanClass().getDeclaredConstructor(constructor.getParameterTypes()).newInstance(args);
    }
}
