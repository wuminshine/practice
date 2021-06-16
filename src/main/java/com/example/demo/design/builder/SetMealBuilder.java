package com.example.demo.design.builder;

/**
 * 建造具体的大对象
 */
public class SetMealBuilder {

    /**
     * 麦当劳经典套餐
     * @return
     */
    SetMeal classicPack()
    {
        Burger burger = new ChickenBurger();
        CokeDrink drink = new CokeDrink();
        Snack frenchFries = new FrenchFriesSnack();
        SetMeal classicSetMeal = new SetMeal();
        classicSetMeal.addItem(burger);
        classicSetMeal.addItem(drink);
        classicSetMeal.addItem(frenchFries);
        return classicSetMeal;
    }
}
