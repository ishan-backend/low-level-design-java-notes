package designpatterns.solid.ocp.violation;

import designpatterns.solid.common.SuperHero;

import java.util.List;

public class Attacker {

    public void attackWithSuperHeroes(List<SuperHero> superHeroes) {
        for(int i=0; i<superHeroes.size(); i++) {
            SuperHero superHero = superHeroes.get(i);
            switch (superHero) {
                case CAPTAIN_AMERICA:
                    superHero.attackWithCaptainAmerica();
                    break;
                case IRONMAN:
                    superHero.attackWithIronMan();
                    break;
                case HULK:
                    superHero.attackWithHulk();
                    break;
            }
        }
    }
}
