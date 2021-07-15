package com.example.demo.spring.context.support;

import com.example.demo.spring.beans.factory.ConfigurableListableBeanFactory;
import com.example.demo.spring.beans.factory.support.DefaultListableBeanFactory;

/**
 * 获取bean工厂并加载资源
 */
public abstract class   AbstractRefreshableApplicationContext extends AbstractApplicationContext {

    private DefaultListableBeanFactory beanFactory;


    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }

    @Override
    protected void refreshBeanFactory() throws Exception {
        DefaultListableBeanFactory beanFactory = createBeanFactory();

        // 加载类定义
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws Exception;

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

}
