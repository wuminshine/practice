package com.example.demo.spring.beans.factory.test;

import com.example.demo.spring.beans.PropertyValue;
import com.example.demo.spring.beans.PropertyValues;
import com.example.demo.spring.beans.factory.BeanDefinition;
import com.example.demo.spring.beans.factory.BeanFactoryPostProcessor;
import com.example.demo.spring.beans.factory.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws Exception {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }
}
