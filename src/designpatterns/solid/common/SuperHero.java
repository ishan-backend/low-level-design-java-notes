package designpatterns.solid.common;


// Different superheros will have different ways of attacking
public enum SuperHero {
    CAPTAIN_AMERICA,
    IRONMAN,
    HULK;

    public void attackWithCaptainAmerica() {
        System.out.println("attacking with captain america");
    }

    public void attackWithIronMan() {
        System.out.println("attacking with ironman");
    }

    public void attackWithHulk() {
        System.out.println("attack with hulk");
    }
}
