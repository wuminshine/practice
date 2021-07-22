package com.example.demo.spring.beans.factory;

/**
 * 销毁操作接口
 */
public interface DisposableBean {

    void destory() throws Exception;
}
