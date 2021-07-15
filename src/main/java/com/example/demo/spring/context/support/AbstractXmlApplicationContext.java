package com.example.demo.spring.context.support;

import com.example.demo.spring.beans.factory.support.DefaultListableBeanFactory;
import com.example.demo.spring.beans.factory.xml.XmlBeanDefinitionReader;

public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext{
    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        for(String configLocation:configLocations)
        {
            xmlBeanDefinitionReader.loadBeanDefinitions(configLocation);
        }
    }

    protected abstract String[] getConfigLocations();
}
