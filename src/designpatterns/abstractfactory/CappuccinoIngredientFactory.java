package designpatterns.abstractfactory;

public class CappuccinoIngredientFactory implements IngredientFactory {
    @Override
    public Bean getBean() {
        return new FrenchBean();
    }

    @Override
    public Sugar getSugar() {
        return new BrownSugar();
    }

    @Override
    public Milk getMilk() {
        return new CowMilk();
    }
}
