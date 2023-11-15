package designpatterns.abstractfactory;

// Cappuccino client should only pass desired type of ingredientFactory, since we want to decouple ingredient knowledge from product
public class Cappucino extends Coffee { // Cappuccino is child of Coffee class

    // Cappuccino constructor - American bean + brown sugar + cow milk
    public Cappucino(IngredientFactory ingredientFactory) {
        super(ingredientFactory); // what ever you pass gets passed to the parent
    }

    @Override
    public void boil() {}

    @Override
    public void brew() {}
}
