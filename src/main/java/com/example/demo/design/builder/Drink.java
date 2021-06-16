package com.example.demo.design.builder;

public abstract class Drink implements Item {
    @Override
    public void desc() {
        System.out.println("我是饮料类~~~");
    }
}
