package com.example.demo.spring.beans.factory;

/**
 * 初始化接口
 */
public interface InitializingBean {
    void afterPropertiesSet() throws Exception;
}
