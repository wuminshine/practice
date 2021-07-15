package com.example.demo.spring.beans.factory.support;

import com.example.demo.spring.beans.factory.BeanDefinition;
import com.example.demo.spring.beans.factory.BeanPostProcessor;
import com.example.demo.spring.beans.factory.config.ConfigurableBeanFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 定义获取bean的模板
 *  1、获取BeanDefinition
 *  2、根据BeanDefinition创建bean
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableBeanFactory {

    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    /**
     * 定义getBean的模板
     * @return
     */
    @Override
    public Object getBean(String beanName) throws Exception {
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return createBean(beanName, beanDefinition);
    }

    @Override
    public Object getBean(String beanName, Object... args) throws Exception {
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return createBean(beanName, beanDefinition, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws Exception {
        return (T)getBean(name);
    }

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws Exception;

    abstract BeanDefinition getBeanDefinition(String beanName);

    abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws Exception;

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        this.beanPostProcessors.add(beanPostProcessor);
    }

    public List<BeanPostProcessor> getBeanPostProcessors() {
        return beanPostProcessors;
    }
}
