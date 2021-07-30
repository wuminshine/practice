package com.example.demo.spring.beans.factory.support;

import com.example.demo.spring.beans.factory.DisposableBean;
import com.example.demo.spring.beans.factory.SingletonBeanRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 单例对象获取实现类
 */
@Slf4j
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    Map<String, Object> singleInstanceMap = new HashMap<>();

    Map<String, DisposableBean> disposableBeans = new HashMap<>();

    /**
     * 获取单例对象
     * @param beanName
     * @return
     */
    @Override
    public Object getSingleton(String beanName) {
        return singleInstanceMap.get(beanName);
    }

    /**
     * 缓存单例对象
     * @param beanName
     * @param instance
     */
    public void addSingleton(String beanName, Object instance)
    {
        singleInstanceMap.put(beanName, instance);
    }

    public void registerDisposableBean(String beanName, DisposableBean disposableBean)
    {
        disposableBeans.put(beanName, disposableBean);
    }

    /**
     * 销毁对象
     */
    public void destroySingletons()
    {
        Set<String> disposableBeanKeys = disposableBeans.keySet();
        if (CollectionUtils.isEmpty(disposableBeanKeys))
        {
            return;
        }
        Object[] disposableBeanArray = disposableBeanKeys.toArray();
        for (int i = disposableBeanArray.length - 1; i>=0; i--)
        {
            DisposableBean disposableBean = disposableBeans.remove(disposableBeanArray[i]);
            try {
                disposableBean.destory();
            } catch (Exception e) {
                log.error("执行销毁方法报错");
                e.printStackTrace();
            }
        }
    }
}
