package designpatterns.decorator.dominos.decorator;

import designpatterns.decorator.dominos.decorator.toppings.Olive;
import designpatterns.decorator.dominos.decorator.toppings.Onion;

public class PizzaSimulator {
    public static void main(String[] args) {
        Pizza pizza = new Onion(new Olive(new ThinCrustPizza()));
        System.out.println(pizza.getName() + " pizza: Rs." + pizza.getCost());

    }
}
