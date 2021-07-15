package com.example.demo.spring.context.support;

import com.example.demo.spring.beans.core.io.DefaultResourceLoader;
import com.example.demo.spring.beans.factory.BeanFactoryPostProcessor;
import com.example.demo.spring.beans.factory.BeanPostProcessor;
import com.example.demo.spring.beans.factory.ConfigurableListableBeanFactory;
import com.example.demo.spring.context.ConfigurableApplicationContext;

import java.util.Map;

/**
 * 应用上下文抽象类实现
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

    @Override
    public void refresh() throws Exception {

        // 创建BeanFactory，并加载BeanDefinition
        refreshBeanFactory();

        // 获取BeanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();

        // 在bean实例化之前，先执行BeanFactoryPostProcessor
        invokeBeanFactoryPostProcessors(beanFactory);

        // 注册BeanPostProcessors
        registerBeanPostProcessors(beanFactory);

        // 提前实例化单例bean对象
        beanFactory.preInstantiateSingletons();
    }

    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) throws Exception {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for(BeanPostProcessor beanPostProcessor:beanPostProcessorMap.values())
        {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) throws Exception {
        Map<String, BeanFactoryPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for(BeanFactoryPostProcessor beanFactoryPostProcessor:beanPostProcessorMap.values())
        {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    protected abstract void refreshBeanFactory() throws Exception;

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws Exception {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    @Override
    public Object getBean(String name) throws Exception {
        return getBeanFactory().getBean(name);
    }

    @Override
    public Object getBean(String name, Object... args) throws Exception {
        return getBeanFactory().getBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws Exception {
        return getBeanFactory().getBean(name, requiredType);
    }

}
