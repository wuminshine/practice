package com.example.demo.spring.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.example.demo.spring.beans.BeanReference;
import com.example.demo.spring.beans.PropertyValue;
import com.example.demo.spring.beans.PropertyValues;
import com.example.demo.spring.beans.factory.*;
import com.example.demo.spring.beans.factory.config.AutowireCapableBeanFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.management.remote.rmi._RMIConnection_Stub;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

/**
 * 定义创建bean的公共行为
 */
@Slf4j
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory implements AutowireCapableBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibInstantiationStrategy();

    /**
     * 先判断是否有缓存的单例对象，有就直接返回，否则通过反射创建实例
     * @param beanName
     * @param beanDefinition
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    @Override
    Object createBean(String beanName, BeanDefinition beanDefinition) throws Exception {
        Object singletonInstance = getSingleton(beanName);
        if (singletonInstance != null)
        {
            return singletonInstance;
        }
        Object instance = beanDefinition.getBeanClass().newInstance();
        // 填充bean的属性，这是一个递归的过程，不只有基本类型的属性，还有引用类型的属性
        applyPropertyValues(instance, beanDefinition);
        // 执行bean的初始化方法和BeanPostProcessors前后方法
        initializeBean(beanName, instance, beanDefinition);

        registerDisposableBeanIfNecessary(beanName, instance, beanDefinition);
        addSingleton(beanName, instance);
        return instance;
    }

    protected void registerDisposableBeanIfNecessary(String beanName, Object instance, BeanDefinition beanDefinition) {
        if (instance instanceof DisposableBean || StringUtils.isNotEmpty(beanDefinition.getDestoryMethodName()))
        {
            registerDisposableBean(beanName, new DisposableBeanAdapter(instance, beanName, beanDefinition));
        }
    }

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws Exception {
        Object singletonInstance = getSingleton(beanName);
        if (singletonInstance != null)
        {
            return singletonInstance;
        }

        // 创建bean实例
        Object instance = createBeanInstance(beanName, beanDefinition, args);

        // 填充bean的属性，这是一个递归的过程，不只有基本类型的属性，还有引用类型的属性
        applyPropertyValues(instance, beanDefinition);

        // 执行bean的初始化方法和BeanPostProcessors前后方法
        initializeBean(beanName, instance, beanDefinition);

        // 注册销毁函数
        registerDisposableBeanIfNecessary(beanName, instance, beanDefinition);
        addSingleton(beanName, instance);
        return instance;

    }

    private Object initializeBean(String beanName, Object instance, BeanDefinition beanDefinition) throws Exception {
        // 执行BeanPostProcessor before处理
        Object wrappedBean = applyBeanPostProcessorsBeforeInitialization(instance, beanName);

        // 待完成内容
        invokeInitMethods(beanName, wrappedBean, beanDefinition);

        // 执行BeanPostProcessor after处理
        wrappedBean = applyBeanPostProcessorsAfterInitialization(instance, beanName);
        return wrappedBean;
    }

    /**
     * 执行bean的初始化方法
     * @param beanName
     * @param wrappedBean
     * @param beanDefinition
     */
    private void invokeInitMethods(String beanName, Object wrappedBean, BeanDefinition beanDefinition) throws Exception {
        if (wrappedBean instanceof InitializingBean)
        {
            ((InitializingBean)wrappedBean).afterPropertiesSet();
        }
        String initMethodName = beanDefinition.getInitMethodName();
        if (StringUtils.isNotEmpty(initMethodName))
        {
            Method method = beanDefinition.getBeanClass().getMethod(initMethodName);
            if(null == method)
            {
                log.error("没有获取到定义的初始化方法");
                return;
            }
            method.invoke(wrappedBean);
        }
    }

    @Override
    public Object applyBeanPostProcessorsBeforeInitialization(Object existBean, String beanName) {
        Object result = existBean;
        List<BeanPostProcessor> beanPostProcessors = getBeanPostProcessors();
        for(BeanPostProcessor beanPostProcessor: beanPostProcessors)
        {
            Object current = beanPostProcessor.postProcessBeforeInitialization(result, beanName);
            if (null == current)
            {
                return result;
            }
            result = current;
        }
        return result;
    }

    @Override
    public Object applyBeanPostProcessorsAfterInitialization(Object existBean, String beanName) {
        Object result = existBean;
        List<BeanPostProcessor> beanPostProcessors = getBeanPostProcessors();
        for(BeanPostProcessor beanPostProcessor: beanPostProcessors)
        {
            Object current = beanPostProcessor.postProcessAfterInitialization(result, beanName);
            if (null == current)
            {
                return result;
            }
            result = current;
        }
        return result;
    }

    public void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception {
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        if (null == propertyValues)
        {
            return;
        }
        List<PropertyValue> propertyValueList = propertyValues.getPropertyValueList();
        for (PropertyValue propertyValue:propertyValueList) {
            String name = propertyValue.getName();
            Object value = propertyValue.getValue();
            if (value instanceof BeanReference)
            {
                value = getBean(name);
            }
            BeanUtil.setFieldValue(bean, name, value);
        }

    }

    public Object createBeanInstance(String beanName, BeanDefinition beanDefinition, Object[] args) throws Exception {
        Constructor[] constructors = beanDefinition.getBeanClass().getDeclaredConstructors();
        Constructor constructor;
        Object instance = null;
        for (int i = 0; i < constructors.length; i++) {
            constructor = constructors[i];
            if (constructor.getParameterTypes().length == args.length)
            {
                instance = instantiationStrategy.instantiate(beanDefinition, beanName, constructor, args);
                break;
            }
        }
        return instance;
    }

}
