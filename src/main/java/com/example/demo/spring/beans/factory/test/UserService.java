package com.example.demo.spring.beans.factory.test;


import com.example.demo.spring.beans.factory.DisposableBean;
import com.example.demo.spring.beans.factory.InitializingBean;
import com.example.demo.spring.context.support.ClassPathXmlApplicationContext;

public class UserService implements InitializingBean, DisposableBean {

    // 注入userDao
    private UserDao userDao;

    private String userId;

    private String company;

    private String location;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * 获取用户信息方法
     * @param userId
     * @return
     */
    public String getUser(String userId)
    {
        return  userDao.getUser(userId);
    }

    @Override
    public String toString() {
        return "UserService{" +
                "userDao=" + userDao +
                ", userId='" + userId + '\'' +
                ", company='" + company + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public String getUser()
    {
        return  userDao.getUser(userId);
    }

    public static void main(String[] args) throws Exception {

//        // 注册UserDao的BeanDefinition
//        BeanDefinition userDaoBeanDefinition = new BeanDefinition(UserDao.class);
//        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
//        defaultListableBeanFactory.registerBeanDefinition("userDao", userDaoBeanDefinition);
//
//        // 注册UserService的BeanDefinition
//        BeanDefinition userServiceDefinition = new BeanDefinition(UserService.class);
//
//        // 定义UserService的属性
//        PropertyValues propertyValues = new PropertyValues();
//        PropertyValue propertyValue = new PropertyValue();
//        propertyValue.setName("userDao");
//        BeanReference userDaoReference = new BeanReference();
//        userDaoReference.setBeanName("userDao");
//        propertyValue.setValue(userDaoReference);
//        propertyValues.addPropertyValue(propertyValue);
//        userServiceDefinition.setPropertyValues(propertyValues);
//
//        // 注册UserService的BeanDefinition
//        defaultListableBeanFactory.registerBeanDefinition("userService", userServiceDefinition);
//
//        // 获取UserService对象
//        UserService usesrService = (UserService) defaultListableBeanFactory.getBean("userService");
//        System.out.println(usesrService.getUser("2"));


        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutDownHook();
        // 2. 获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.getUser();
        System.out.println("测试结果：" + result);
        System.out.println("userService：" + userService);
    }

    @Override
    public void destory() throws Exception {
        System.out.println("执行userservice销毁方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("执行userservice初始化方法");
    }
}
