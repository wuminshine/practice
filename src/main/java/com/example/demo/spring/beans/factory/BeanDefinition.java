package com.example.demo.spring.beans.factory;

import com.example.demo.spring.beans.PropertyValues;

/**
 * 抽象Bean的定义
 */
public class BeanDefinition {

    public Class beanClass;

    /**
     * bean的属性
     */
    public PropertyValues propertyValues;

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

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
