package com.example.demo.spring.beans.factory;

import com.example.demo.spring.beans.PropertyValues;
import lombok.Data;

/**
 * 抽象Bean的定义
 */
@Data
public class BeanDefinition {

    public Class beanClass;

    /**
     * 初始化方法名字
     */
    public String initMethodName;

    /**
     * 销毁方法名字
     */
    public String destoryMethodName;

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
