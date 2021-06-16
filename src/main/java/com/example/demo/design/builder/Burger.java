package com.example.demo.design.builder;

/**
 * 汉堡类
 */
public abstract class Burger implements Item {
    @Override
    public void desc() {
        System.out.println("我是汉堡类~~~");
    }
}
