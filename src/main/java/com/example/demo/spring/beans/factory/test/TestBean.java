package com.example.demo.spring.beans.factory.test;

public class TestBean {
    private String name;

    public TestBean(String name) {
        this.name = name;
    }

    public void doSomething()
    {
        System.out.println(this.name);
    }

}
