package com.example.demo.spring.beans.factory.support;

import com.example.demo.spring.beans.factory.BeanDefinition;
import com.example.demo.spring.beans.factory.BeanFactory;

/**
 * 定义获取bean的模板
 *  1、获取BeanDefinition
 *  2、根据BeanDefinition创建bean
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory  {

    /**
     * 定义getBean的模板
     * @return
     */
    @Override
    public Object getBean(String beanName) throws InstantiationException, IllegalAccessException {
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return createBean(beanName, beanDefinition);
    }

    abstract BeanDefinition getBeanDefinition(String beanName);

    abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws IllegalAccessException, InstantiationException;
}
