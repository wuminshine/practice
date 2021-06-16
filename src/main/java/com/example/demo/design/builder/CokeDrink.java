package com.example.demo.design.builder;

public class CokeDrink extends Drink {
    @Override
    public String name() {
        return "我是可乐";
    }

    @Override
    public float price() {
        return 6.5f;
    }
}
