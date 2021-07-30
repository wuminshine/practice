package com.example.demo.spring.beans.factory.support;

import com.example.demo.spring.beans.factory.BeanDefinition;
import com.example.demo.spring.beans.factory.DisposableBean;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Method;

/**
 *
 */
@Slf4j
public class DisposableBeanAdapter implements DisposableBean {

    private final Object bean;

    private final String beanName;

    private String destoryMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destoryMethodName = beanDefinition.getDestoryMethodName();
    }

    @Override
    public void destory() throws Exception {

        // 实现销毁接口
        if (bean instanceof DisposableBean)
        {
            ((DisposableBean) bean).destory();
        }

        // 配置了销毁的方法
        if (StringUtils.isNotEmpty(destoryMethodName))
        {
            Method method = bean.getClass().getMethod(destoryMethodName);
            if (null == method)
            {
                log.error("未找到指定的销毁方法");
            }
            method.invoke(bean);
        }

    }
}
