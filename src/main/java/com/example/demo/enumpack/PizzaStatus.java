package com.example.demo.enumpack;

public enum PizzaStatus {
    ORDERED,
    READY,
    CANCELED;
}
class enumTest
{
    public static void main(String[] args) {
        System.out.println(PizzaStatus.ORDERED.ordinal());
        System.out.println(PizzaStatus.READY.ordinal());
        System.out.println(PizzaStatus.CANCELED.ordinal());
    }
}