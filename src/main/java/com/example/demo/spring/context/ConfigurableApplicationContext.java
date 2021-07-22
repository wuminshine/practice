package com.example.demo.spring.context;

public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新容器
     */
    void refresh() throws Exception;

    /**
     * 注册关闭钩子函数
     */
    void registerShutDownHook();

    void close();
}
