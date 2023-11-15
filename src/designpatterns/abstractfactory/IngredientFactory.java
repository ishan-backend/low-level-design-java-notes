package designpatterns.abstractfactory;

public interface IngredientFactory {
    Bean getBean();
    Sugar getSugar();
    Milk getMilk();
}
