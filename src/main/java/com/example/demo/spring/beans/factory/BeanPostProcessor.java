package com.example.demo.spring.beans.factory;

public interface BeanPostProcessor {

    /**
     * 在bean初始化之前执行此方法
     * @param bean
     * @param beanName
     * @return
     */
    Object postProcessBeforeInitialization(Object bean, String beanName);

    /**
     * 在bean初始化之后执行此方法
     * @param bean
     * @param beanName
     * @return
     */
    Object postProcessAfterInitialization(Object bean, String beanName);
}
