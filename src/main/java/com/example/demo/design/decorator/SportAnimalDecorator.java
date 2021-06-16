package com.example.demo.design.decorator;

/**
 * 吃完运动适配器类
 */
public class SportAnimalDecorator extends AnimalDecorator {

    public SportAnimalDecorator(Animal animal) {
        super(animal);
    }

    @Override
    public void eat() {
        super.eat();
        sportAfterEat();
    }

    private void sportAfterEat()
    {
        System.out.println("吃完以后运动运动呀~~~");

    }
}
