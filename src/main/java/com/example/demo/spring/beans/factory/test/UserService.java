package com.example.demo.spring.beans.factory.test;


import com.example.demo.spring.beans.BeanReference;
import com.example.demo.spring.beans.PropertyValue;
import com.example.demo.spring.beans.PropertyValues;
import com.example.demo.spring.beans.factory.BeanDefinition;
import com.example.demo.spring.beans.factory.support.DefaultListableBeanFactory;

public class UserService {

    // 注入userDao
    private UserDao userDao;

    private String userId;

    /**
     * 获取用户信息方法
     * @param userId
     * @return
     */
    public String getUser(String userId)
    {
        return  userDao.getUser(userId);
    }

    public String getUser()
    {
        return  userDao.getUser(userId);
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

        // 注册UserDao的BeanDefinition
        BeanDefinition userDaoBeanDefinition = new BeanDefinition(UserDao.class);
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        defaultListableBeanFactory.registerBeanDefinition("userDao", userDaoBeanDefinition);

        // 注册UserService的BeanDefinition
        BeanDefinition userServiceDefinition = new BeanDefinition(UserService.class);

        // 定义UserService的属性
        PropertyValues propertyValues = new PropertyValues();
        PropertyValue propertyValue = new PropertyValue();
        propertyValue.setName("userDao");
        BeanReference userDaoReference = new BeanReference();
        userDaoReference.setBeanName("userDao");
        propertyValue.setValue(userDaoReference);
        propertyValues.addPropertyValue(propertyValue);
        userServiceDefinition.setPropertyValues(propertyValues);

        // 注册UserService的BeanDefinition
        defaultListableBeanFactory.registerBeanDefinition("userService", userServiceDefinition);

        // 获取UserService对象
        UserService usesrService = (UserService) defaultListableBeanFactory.getBean("userService");
        System.out.println(usesrService.getUser("2"));
    }
}
