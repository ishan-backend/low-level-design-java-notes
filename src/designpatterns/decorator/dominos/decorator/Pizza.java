package designpatterns.decorator.dominos.decorator;

public abstract class Pizza {
    private final String name;
    private final double cost;

    protected Pizza(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }


    public double getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }
}
