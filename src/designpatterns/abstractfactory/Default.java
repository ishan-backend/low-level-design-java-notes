package designpatterns.abstractfactory;

public class Default extends Coffee {

    // Robusta constructor
    public Default(IngredientFactory ingredientFactory) {
        super(ingredientFactory);
    }

    @Override
    public void boil() {

    }

    @Override
    public void brew() {

    }
}
