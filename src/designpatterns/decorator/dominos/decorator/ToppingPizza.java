package designpatterns.decorator.dominos.decorator;

// ToppingPizza is great example of extension achieved because of composition
// composition is achieved by polymorphic type
public abstract class ToppingPizza extends Pizza{
    private final Pizza pizza;
    protected ToppingPizza(String name, double cost, Pizza pizza) { // for new topping : name & cost, pizza to put topping on & topping itself is also pizza
        super(name, cost); // super is class to decorate - initializes topping as Pizza
        this.pizza = pizza; // sets pizza on top of which topping to put
    }

    @Override
    public double getCost() {
        return super.getCost() + pizza.getCost(); // topping cost + pizza cost
        // Delegation of work: super/topping does it work, and delegates rest of work to underlying pizza
        // pizza can be of two type: base / topping
        // if base then directly return cost
        // else add topping cost and delegate to underlying pizza
    }

    @Override
    public String getName() {
        return super.getName() + " " + pizza.getName();
    }
}
