package com.example.demo.design.decorator;

/**
 * 基础适配器
 *  1、这一层抽象基础适配器的作用是将接口中的基础的能力进行实现，因为具体的适配器可能有多个，每个适配器完成的作用也是不一样的
 *    但是有一些公共的功能就在基础适配器中实现，不需要每个具体适配器都实现一遍
 */
public abstract class AnimalDecorator implements Animal{

    private Animal animal;

    public AnimalDecorator(Animal animal) {
        this.animal = animal;
    }

    @Override
    public void eat() {
        animal.eat();
    }

    @Override
    public void sleep() {
        animal.sleep();
    }
}
