package com.example.demo.enumpack;

public class Pizza {
    private PizzaStatus pizzaStatus;

    public PizzaStatus getPizzaStatus() {
        return pizzaStatus;
    }

    public void setPizzaStatus(PizzaStatus pizzaStatus) {
        this.pizzaStatus = pizzaStatus;
    }

    public enum PizzaStatus{
        ORDERED(1){
            @Override
            protected boolean isOrdered() {
                return true;
            }
        },
        READY(2){
            @Override
            protected boolean isReady() {
                return true;
            }
        },
        CANCELED(3){
            @Override
            protected boolean isCanceled() {
                return true;
            }
        };
        private int statusOrder;

        PizzaStatus(int statusOrder) {
            this.statusOrder = statusOrder;
        }

        public int getStatusOrder() {
            return statusOrder;
        }

        public void setStatusOrder(int statusOrder) {
            this.statusOrder = statusOrder;
        }

        protected boolean isOrdered(){return false;}
        protected boolean isReady(){return false;}
        protected boolean isCanceled(){return false;}
    }

    public boolean isCanceled()
    {
        return getPizzaStatus() == PizzaStatus.CANCELED;
    }

    public void switchStatus(PizzaStatus status)
    {
        switch (status)
        {
            case ORDERED:
                break;
            case READY:
                break;
            case CANCELED:
                System.out.println("cancled");
                break;
            default:
                break;
        }
    }
}
class pizzaTest
{
    public static void main(String[] args) {
//        Pizza pizza = new Pizza();
//        pizza.switchStatus(Pizza.PizzaStatus.CANCELED);
//        System.out.println(pizzaStatus.equals(Pizza.PizzaStatus.ORDERED));
//        System.out.println(pizzaStatus == Pizza.PizzaStatus.ORDERED);

        System.out.println(Pizza.PizzaStatus.CANCELED.isCanceled());
        System.out.println(Pizza.PizzaStatus.CANCELED.isOrdered());
        System.out.println(Pizza.PizzaStatus.ORDERED.getStatusOrder());
    }
}
