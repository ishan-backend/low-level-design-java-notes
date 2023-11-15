package designpatterns.factory;

public class CoffeeFactory {
    public Coffee getCoffee(String coffeeType) {
        Coffee coffee;
        if (coffeeType.equals("Cappuccino"))
            coffee = new Cappucino();
        else
            coffee = new Robusta();

        // Factory are still violating DIP by creating a lot of concrete classes instances but, they are now centralised location for creation of objects
        return coffee;
    }
}

/*
    CoffeeServer (CC) -> (depends on to compile) CoffeeFactory (CC) -> Cappucino (CC), Robusta (CC)
    Coffee (I) -> (implemented by) Cappucino (CC), Robusta (CC)
*/

/*  Benefit of using Factory:
    * Creational responsibility is not localised
    * Not directly depending on lot of concrete classes

    Problem:
    * Since we are dependent on concrete type CoffeeFactory, there's still dependency of CoffeeServer on CoffeeFactory to compile & CoffeeFactory on Cappucino, Robusta to compile.
    * So now to solve this dependency chain, we will code CoffeeFactory against an interface AbstractFactory. Post that CoffeeServer only depends on interface CoffeeFactory
*/
