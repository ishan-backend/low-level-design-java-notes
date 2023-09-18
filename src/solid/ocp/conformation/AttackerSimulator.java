package solid.ocp.conformation;

import java.util.ArrayList;
import java.util.List;

public class AttackerSimulator {
    public static void main(String []args) {
        Attacker attacker = new Attacker();
        List<SuperHero> superHeroes = new ArrayList<>();
        superHeroes.add(new Hulk());
        superHeroes.add(new IM());
        attacker.attackWithSuperHeroes(superHeroes);
    }
}