package com.example.demo.design.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * 定义建造的行为
 */
public class SetMeal {
    private List<Item> itemList = new ArrayList<>();

    /**
     * 传入套餐对象
     * @param item
     */
    public void addItem(Item item)
    {
        itemList.add(item);
    }

    /**
     * 计算套餐价格
     * @return
     */
    public float getPrice()
    {
        float totalPrice = 0;
        for (Item item:itemList)
        {
            totalPrice += item.price();
        }
        return totalPrice;
    }

    /**
     * 展示套餐内容
     */
    public void showItem()
    {
        System.out.println("套餐内容如下：");
        for (Item item:itemList)
        {
            System.out.println(item.name());
        }
    }
}
