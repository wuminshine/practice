package com.example.demo.spring.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.example.demo.spring.beans.BeanReference;
import com.example.demo.spring.beans.PropertyValue;
import com.example.demo.spring.beans.PropertyValues;
import com.example.demo.spring.beans.factory.BeanDefinition;
import com.example.demo.spring.beans.factory.InstantiationStrategy;

import java.lang.reflect.Constructor;
import java.util.List;

/**
 * 定义创建bean的公共行为
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

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
    Object createBean(String beanName, BeanDefinition beanDefinition) throws IllegalAccessException, InstantiationException {
        Object singletonInstance = getSingleton(beanName);
        if (singletonInstance != null)
        {
            return singletonInstance;
        }
        Object instance = beanDefinition.getBeanClass().newInstance();
        // 填充bean的属性，这是一个递归的过程，不只有基本类型的属性，还有引用类型的属性
        applyPropertyValues(instance, beanDefinition);
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
        addSingleton(beanName, instance);
        return instance;

    }

    public void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws IllegalAccessException, InstantiationException {
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
