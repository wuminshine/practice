package com.example.demo.spring.beans.factory;

import com.example.demo.spring.beans.factory.config.AutowireCapableBeanFactory;
import com.example.demo.spring.beans.factory.config.ConfigurableBeanFactory;

public interface ConfigurableListableBeanFactory extends ListableBeanFactory, ConfigurableBeanFactory, AutowireCapableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws Exception;

    /**
     * 实例化单例对象
     * @throws Exception
     */
    void preInstantiateSingletons() throws Exception;

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

}
