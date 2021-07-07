package com.example.demo.spring.beans.factory;

/**
 * 获取bean的工厂接口，抽象获取bean的行为
 */
public interface BeanFactory {
    /**
     * 根据beanName获取bean
     * @param beanName
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    Object getBean(String beanName) throws InstantiationException, IllegalAccessException;
}
