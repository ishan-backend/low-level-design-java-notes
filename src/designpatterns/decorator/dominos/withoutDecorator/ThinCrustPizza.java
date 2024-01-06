package designpatterns.decorator.dominos.withoutDecorator;

public class ThinCrustPizza extends Pizza{
    @Override
    public double getCost() {return 7.0 + super.getCost();} // override super/abstract class method

    @Override
    public String getName() {return super.getName() + " thin crust pizza";}
}
