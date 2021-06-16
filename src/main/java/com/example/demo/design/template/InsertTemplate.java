package com.example.demo.design.template;

public class InsertTemplate extends JdbcTemplate {
    @Override
    void executeSql() {
        System.out.println("插入sql");
    }
}
