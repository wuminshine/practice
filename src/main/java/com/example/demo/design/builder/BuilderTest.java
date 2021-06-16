package com.example.demo.design.builder;

/**
 * 建造者模式应用场景：构建复杂对象
 * 将复杂对象的构建进行拆解，使得同样的构建步骤可以有不同的表现对象
 * 比如汉堡套餐，包含主食汉堡+小食+饮料，输出套餐内容+价格
 */
public class BuilderTest {

    public static void main(String[] args) {
        SetMealBuilder builder = new SetMealBuilder();
        SetMeal classicSetMeal = builder.classicPack();
        classicSetMeal.showItem();
        System.out.println("总价格为:");
        System.out.println(classicSetMeal.getPrice());
    }
}
