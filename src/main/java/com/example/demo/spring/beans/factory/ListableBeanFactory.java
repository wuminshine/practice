package com.example.demo.spring.beans.factory;

import java.util.Map;

public interface ListableBeanFactory extends BeanFactory{

    /**
     * 按照类型返回bean实例
     * @param type
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws Exception;

    /**
     * 获取注册表中所有的BeanDefinition的name
     * @return
     */
    String[] getBeanDefinitionNames();
}
