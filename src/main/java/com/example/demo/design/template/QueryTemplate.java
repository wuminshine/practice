package com.example.demo.design.template;

public class QueryTemplate extends JdbcTemplate {
    @Override
    void executeSql() {
        System.out.println("查询sql");
    }
}
