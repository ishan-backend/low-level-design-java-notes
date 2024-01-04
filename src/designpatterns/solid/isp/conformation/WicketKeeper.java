package designpatterns.solid.isp.conformation;

public class WicketKeeper implements Keeper, Player {
    @Override
    public void keep() {
        System.out.println("WicketKeeper is fielding");
    }

    @Override
    public void bat() {
        System.out.println("WicketKeeper is fielding");
    }
}
