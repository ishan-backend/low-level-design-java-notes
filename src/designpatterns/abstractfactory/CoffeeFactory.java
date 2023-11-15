package designpatterns.abstractfactory;

public class CoffeeFactory implements AbstractFactory {

    @Override
    public Coffee getCoffee(String coffeeType) {
        Coffee coffee;
        if (coffeeType.equals("Cappuccino"))
            coffee = new Cappucino(new CappuccinoIngredientFactory()); // needs to pass appropriate concrete type of ingredient factory here, CappuccinoIngredientFactory
        else if (coffeeType.equals("Robusta"))
            coffee = new Robusta(new RobustaIngredientFactory());
        else
            coffee = new Default(new DefaultIngredientFactory());
        return coffee;
    }
}

/*
CoffeeFactory handles the following :-
1. Creation Responsibility wrt Coffee (parent class of all coffee types) - it gathers right kind of Coffee object e.g. Cappuccino, Robusta
2. If it remembers ingredients of a Coffee Type -> It would overburden the class. Any change to recipe changes would then change this CoffeeFactory class.
 e.g coffee = new Cappucino(new FrenchBean(), new BrownSugar(), new CowMilk()); for cappuccino

* CoffeeFactory should only worry about creating instance of Cappuccino for Cappuccino, and Robusta for Robusta.
* It should not worry about ingredients for instances, i.e. if some ingredients changed / added / removed, we should not be required to change CoffeeFactory class.
* In other words, we need to abstract out the ingredients knowledge in Interface IngredientFactory

* * That means, knowledge now needs to reside in some other entity say e; here, IngredientFactory
* * To create a Cappuccino object, new Cappucino(e)
* * Entity e is going to tell Cappucino which ingredient it needs to use
* * Cappucino {e, constructor: this->bean = e.getBean()} // getBean() will behave differently for different type of coffee. so entity e should be polymorphic type i.e. interface and it exposes 3 methods. It can have many implementations from Cappuccino, Robusta. You just need to pass correct concrete implementation within Cappuccino class
* * Entity e knows that coffee is made up of sugar, milk, spice, and it also knows exact type of milk, sugar.

AbstractFactory: CoffeeFactory
AbstractEntity (interface) : IngredientFactory which has many concrete types/implementations.
AbstractEntity (abstract class): Coffee which has many concrete implementations like Cappuccino and Robusta
Binding of concrete implementations of coffee and concrete implementations of coffee specific factory happens in CoffeeFactory

CoffeeFactory
*/
