package com.example.demo.design.builder;

public class ChickenBurger extends Burger {
    @Override
    public String name() {
        return "我是鸡肉汉堡~~~";
    }

    @Override
    public float price() {
        return 10.5f;
    }
}
