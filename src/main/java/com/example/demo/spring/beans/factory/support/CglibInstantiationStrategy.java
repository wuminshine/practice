package com.example.demo.spring.beans.factory.support;

import com.example.demo.spring.beans.factory.BeanDefinition;
import com.example.demo.spring.beans.factory.InstantiationStrategy;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Cglib 实例化对象
 */
public class CglibInstantiationStrategy implements InstantiationStrategy {

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        if (null == constructor)
            return enhancer.create();
        return enhancer.create(constructor.getParameterTypes(), args);
    }
}
