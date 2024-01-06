package designpatterns.decorator.dominos.withoutDecorator;

public class WheatBasePizza extends Pizza{
    @Override
    public double getCost() {return 10.0 + super.getCost();} // override super class method

    @Override
    public String getName() {return super.getName() + " wheat base pizza";}
}
