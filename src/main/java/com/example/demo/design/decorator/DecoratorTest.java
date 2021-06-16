package com.example.demo.design.decorator;

/**
 * 装饰器模式的应用场景：给一个类添加额外的功能，避免使用过多子类，造成类臃肿
 * 装饰器模式涉及两个类
 *  1、一个类A实现被装饰接口，在构造函数中传入被装饰的类
 *  2、类B继承类A，重写接口方法，添加装饰的行为
 */
public class DecoratorTest {

    public static void main(String[] args) {
        Animal dog = new Dog();
        SportAnimalDecorator decorator = new SportAnimalDecorator(dog);
        decorator.eat();
        Animal cat = new Cat();
        SportAnimalDecorator catDecorator = new SportAnimalDecorator(cat);
        catDecorator.eat();
    }
}
