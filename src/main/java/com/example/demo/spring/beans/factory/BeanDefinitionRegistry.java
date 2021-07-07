package com.example.demo.spring.beans.factory;

/**
 * 抽象BeanDefinition的注册行为
 */
public interface BeanDefinitionRegistry {
    /**
     * 注册BeanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
