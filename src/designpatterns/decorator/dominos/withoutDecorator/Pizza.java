package designpatterns.decorator.dominos.withoutDecorator;

import designpatterns.decorator.dominos.withoutDecorator.data.Mushroom;
import designpatterns.decorator.dominos.withoutDecorator.data.Olive;
import designpatterns.decorator.dominos.withoutDecorator.data.Onion;

public abstract class Pizza {
    // toppings as instance variables
    private Mushroom mushroom;
    private Onion onion;
    private Olive olive;

    public double getCost() {
        double cost = 0;
        if(mushroom != null) {
            cost += mushroom.getCost();
        }
        if(onion != null) {
            cost += onion.getCost();
        }
        if(olive != null) {
            cost += olive.getCost();
        }
        return cost;
    }

    public String getName() {
        String name = "";
        if(mushroom != null) {
            name += mushroom.getName() + " ";
        }
        if(onion != null) {
            name += onion.getName() + " ";
        }
        if(olive != null) {
            name += olive.getName() + " ";
        }
        return name;
    }

    // setters, since field is optional
    // todo: use builder pattern to set instead of this
    public void setMushroom(Mushroom mushroom) {
        this.mushroom = mushroom;
    }

    public void setOlive(Olive olive) {
        this.olive = olive;
    }

    public void setOnion(Onion onion) {
        this.onion = onion;
    }
}
