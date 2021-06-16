package com.example.demo.design.builder;

public abstract class Snack implements Item {
    @Override
    public void desc() {
        System.out.println("我是小食类~~~");
    }
}
