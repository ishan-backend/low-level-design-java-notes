package designpatterns.solid.ocp.conformation;

import java.util.List;

public class Attacker {
    public void attackWithSuperHeroes(List<SuperHero> superHeroList) {
        // SuperHero is interface
        for(int i=0; i<superHeroList.size(); i++) {
            SuperHero superHero = superHeroList.get(i);
            superHero.attack();
        }
    }
}
