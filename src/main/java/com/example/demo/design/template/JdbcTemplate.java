package com.example.demo.design.template;

/**
 * 模板类，定义模板行为
 */
public abstract class JdbcTemplate {
    abstract void executeSql();

    protected void execute()
    {
        beginTransaction();
        executeSql();
        closeTransaction();
    }

    protected void beginTransaction()
    {
        System.out.println("开启事务~~~");
    }

    protected void closeTransaction()
    {
        System.out.println("关闭事务~~~~");
    }
}
