package com.example.demo.spring.beans.factory;

/**
 * 在所有的BeanDefinition加载完成后，在实例化bean之前，修改BeanDefiniton的属性
 */
public interface BeanFactoryPostProcessor {

    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws Exception;
}
