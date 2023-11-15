package designpatterns.factory;

public class Tester {

    public static void main(String[] args) {
        CoffeeServer coffeeServer = new CoffeeServer();
        coffeeServer.serve("Robusta");
    }
}
