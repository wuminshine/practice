package com.example.demo.spring.beans.factory.config;

import com.example.demo.spring.beans.factory.BeanPostProcessor;
import com.example.demo.spring.beans.factory.HierarchicalBeanFactory;
import com.example.demo.spring.beans.factory.SingletonBeanRegistry;

public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
