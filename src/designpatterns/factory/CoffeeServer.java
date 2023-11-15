package designpatterns.factory;

public class CoffeeServer {

    public Coffee serve(String coffeeType) {
        /*
            Coffee coffee; // interface, abstract type
            if (coffeeType.equals("Cappuccino"))
                coffee = new Cappucino(); // directly depend on concrete , which violates DIP
            else
                coffee = new Robusta();
            coffee.brew();
            coffee.boil();
        */


        Coffee coffee1 = new CoffeeFactory().getCoffee(coffeeType); // Coffee class code only depend on interfaces / Coffee interface to compile. This helps to reduce dependency chain.
        coffee1.brew();
        coffee1.boil();
        return coffee1;
    }
}

/*
* Mapping between coffeeType and Coffee objects
* Currently CoffeeServer needs to know of this mapping
* Tmrw, CoffeePriceServer might need to create a object of Coffee type and calculate prices for these types.
*
* These are creational responsibility, which can be made reusable. Type -> Object. This needs to be implemented in a centralised class, which other modules can use.
* Different types of objects on basis of different patterns.
* */
