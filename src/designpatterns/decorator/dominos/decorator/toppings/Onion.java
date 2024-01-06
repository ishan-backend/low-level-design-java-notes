package designpatterns.decorator.dominos.decorator.toppings;

import designpatterns.decorator.dominos.decorator.Pizza;
import designpatterns.decorator.dominos.decorator.ToppingPizza;

public class Onion extends ToppingPizza {
    public Onion(Pizza pizza) {
        super("onion", 50, pizza);
    }
}
