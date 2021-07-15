package com.example.demo.spring.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.example.demo.spring.beans.BeanReference;
import com.example.demo.spring.beans.PropertyValue;
import com.example.demo.spring.beans.PropertyValues;
import com.example.demo.spring.beans.factory.BeanDefinition;
import com.example.demo.spring.beans.factory.BeanPostProcessor;
import com.example.demo.spring.beans.factory.InstantiationStrategy;
import com.example.demo.spring.beans.factory.config.AutowireCapableBeanFactory;

import java.lang.reflect.Constructor;
import java.util.List;

/**
 * 定义创建bean的公共行为
 */
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
        addSingleton(beanName, instance);
        return instance;
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

        addSingleton(beanName, instance);
        return instance;

    }

    private Object initializeBean(String beanName, Object instance, BeanDefinition beanDefinition) {
        // 执行BeanPostProcessor before处理
        Object wrappedBean = applyBeanPostProcessorsBeforeInitialization(instance, beanName);

        // 待完成内容
        invokeInitMethods(beanName, wrappedBean, beanDefinition);

        // 执行BeanPostProcessor after处理
        wrappedBean = applyBeanPostProcessorsAfterInitialization(instance, beanName);
        return wrappedBean;
    }

    private void invokeInitMethods(String beanName, Object wrappedBean, BeanDefinition beanDefinition) {
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
