package designpatterns.abstractfactory;

public class Robusta extends Coffee {

    // Robusta constructor
    public Robusta(IngredientFactory ingredientFactory) {
        super(ingredientFactory);
    }

    @Override
    public void boil() {

    }

    @Override
    public void brew() {

    }
}
