**Decorator pattern use-cases (delegation of work)**:

* domino's
* writer to help write in console, file
* BufferedReader, FileReader
    ```Java
        Reader reader = new BufferedReader(new FileReader);
        // decorated file reader with buffered reader
        // file is located in disk
        // what file is reading, buffered reader will store in RAM in buffer
        // when we decorate, we get new complex functionality
    ```

**Requirements for Design Domino's Pizza**:
    - Ordering component
    - Pizza making component
    - Price calc component
    - Send notifications (email, messages)

But our scope will be limited to:
* Creation of different varieties of pizza
* And calculate their cost

**Lets make requirement more concrete**:
* One Base of pizza - can be of different varieties (Thin crust, Wheat, etc)
* Toppings on Base (Onion, Cheese), thus functionalities of toppings can be clubbed together
* Layered Topping on one another (Olive + Corn)

* Complete entity is a Pizza
* Adding another layer of topping say Mushroom, on above Pizza - it will be different form of Pizza but a Pizza only.


**Hints**:
* One base
* Multiple toppings
  * Several combinations of base and topping will result in different pizza

* Code that honors all design principles and varieties above.
* Pizza = [Pizza / Base] + Topping

**Without decorator: What design principle is being broken**:
1. OCP - code should be open for extension , closed for modification
   * Class that is existing is getting modified as time passes
     * more toppings -> Pizza class will change

   * Solution:
     * Change toppings to interface ITopping and let data classes be its concrete impl.
     * But this is also not robust.

2. What if you want to order a pizza with 3 mushroom toppings, 2 cheese etc?
   * Such scenarios won't be supported without decorator

**Without decorator: using abstract class/interface for pizza and varieties as concrete**:

  * leads to class explosion, though it supports extensibility.

**Using decorator**:

    Input: Pizza instance variable +  some decorations  = Output : Pizza instance variable
    Pizza p = new OliveTopping(pizza);

    Pizza is abstract type / polymorphic type, and all toppings etc are implementations of it/pizza only
    Similarly, every base is a pizza only

    Pizza p = new OliveTopping(new OnionTopping(new WheatBase())); // new WheatBase() returns a pizza

