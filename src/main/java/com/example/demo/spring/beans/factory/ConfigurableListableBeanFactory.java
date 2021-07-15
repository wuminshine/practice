package com.example.demo.spring.beans.factory;

import com.example.demo.spring.beans.factory.config.AutowireCapableBeanFactory;

public interface ConfigurableListableBeanFactory extends ListableBeanFactory, HierarchicalBeanFactory, AutowireCapableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws Exception;

    /**
     * 实例化单例对象
     * @throws Exception
     */
    void preInstantiateSingletons() throws Exception;

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

}
