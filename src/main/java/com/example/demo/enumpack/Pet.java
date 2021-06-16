package com.example.demo.enumpack;

public class Pet{
     enum StrategyEnum {
        DOG{
            @Override
            public void speak() {
                System.out.println("汪汪汪~~~");
            }
        },
        CAT{
            @Override
            public void speak() {
                System.out.println("喵喵喵~~~");
            }
        };
        public abstract void speak();
    }
    private StrategyEnum strategyEnum;

    public StrategyEnum getStrategyEnum() {
        return strategyEnum;
    }

    public void setStrategyEnum(StrategyEnum strategyEnum) {
        this.strategyEnum = strategyEnum;
    }
}
class StrategyEnumTest{
    public static void main(String[] args) {
        Pet pet = new Pet();
        pet.setStrategyEnum(Pet.StrategyEnum.CAT);
        pet.getStrategyEnum().speak();
    }
}