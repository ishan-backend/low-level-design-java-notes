package designpatterns.decorator.dominos.decorator.toppings;

import designpatterns.decorator.dominos.decorator.Pizza;
import designpatterns.decorator.dominos.decorator.ToppingPizza;

public class Olive extends ToppingPizza {
    public Olive(Pizza pizza) {
        super("olive", 80, pizza);
    }
}
