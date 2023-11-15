package designpatterns.abstractfactory;


// Coffee is topmost class, it contains IngredientFactory as injection. And make sure that IngredientFactory is passed into constructor
// Several implementations of this abstract class like Cappuccino
public abstract class Coffee {
    // no matter what coffeeType, few ingredients will be used always
    // Note that types of Bean, Sugar, Milk - these can be abstract types (interface / abstract class), since Beans can be of different types hence different implementations.
    private final Bean bean;
    private final Sugar sugar;
    private final Milk milk;
    private final IngredientFactory ingredientFactory;

    protected Coffee(IngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
        this.bean = ingredientFactory.getBean();
        this.sugar = ingredientFactory.getSugar();
        this.milk = ingredientFactory.getMilk();
    }

    abstract void brew();
    abstract void boil();
}
