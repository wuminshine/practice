package com.example.demo.design.decorator;


public class Dog implements Animal {
    @Override
    public void eat() {
        System.out.println("吃饭啦，汪汪汪~~~");
    }

    @Override
    public void sleep() {

    }
}
