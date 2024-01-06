package designpatterns.decorator.dominos.withoutDecoratorClassExplosion;

public class MushroomOnionWheatBasePizza extends Pizza{
    @Override
    public String getName() {
        return null;
    }

    @Override
    public double getCost() {
        return 0;
    }
}

// class explosion - 100s of varieties of pizza
// so its rusty design

// good thing - promoting extension rather than modification
// Existing classes won't be modified
