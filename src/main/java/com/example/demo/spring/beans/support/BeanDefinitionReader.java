package com.example.demo.spring.beans.support;

import com.example.demo.spring.beans.core.io.Resource;
import com.example.demo.spring.beans.core.io.ResourceLoader;
import com.example.demo.spring.beans.factory.BeanDefinitionRegistry;

public interface BeanDefinitionReader {
    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws Exception;

    void loadBeanDefinitions(Resource... resource) throws Exception;

    void loadBeanDefinitions(String location) throws Exception;
}
