package com.example.demo.design.template;

/**
 * 模板模式的应用场景在于：
 *  1、一个操作一系列的执行步骤已经确定好
 *  2、部分步骤是确定好的，在抽象类中实现，部分操作是变化的，由各个子类实现
 *  比如sql操作中，开启关闭事务操作是固定的，sql执行的部分是动态的
 */
public class TemplateTest {
    public static void main(String[] args) {
        JdbcTemplate queryTemplate = new QueryTemplate();
        queryTemplate.execute();

        JdbcTemplate insertTemplate = new InsertTemplate();
        insertTemplate.execute();
    }
}
