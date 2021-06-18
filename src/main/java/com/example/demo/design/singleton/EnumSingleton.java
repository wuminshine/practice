package com.example.demo.design.singleton;

/**
 * 使用枚举实现单例模式
 */
public enum EnumSingleton {
    INSTANCE;

    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    static {
        // 完成对象的初始化
        INSTANCE.setDesc("完成单实例的初始化~~~");
    }

    public static EnumSingleton getInstance()
    {
        return INSTANCE;
    }

    public void doSomething()
    {
        System.out.println("I want to doSomething.");
    }
}
class EnumSingletonTest{
    public static void main(String[] args) {
        EnumSingleton.INSTANCE.doSomething();
        System.out.println(EnumSingleton.INSTANCE.getDesc());
    }
}
