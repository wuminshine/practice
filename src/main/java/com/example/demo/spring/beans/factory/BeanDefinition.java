package com.example.demo.spring.beans.factory;

/**
 * 抽象Bean的定义
 */
public class BeanDefinition {
    public Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
