package designpatterns.solid.isp.conformation;

public class AllRounder implements Player, Fielder, Bowler {

    @Override
    public void Bowl() {
        System.out.println("AllRounder is bowling");
    }

    @Override
    public void field() {
        System.out.println("AllRounder is fielding");
    }

    @Override
    public void bat() {
        System.out.println("AllRounder is batting");
    }
}
