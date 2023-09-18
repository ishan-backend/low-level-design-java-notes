package solid.isp.conformation;

public class PureBatsman implements Player, Fielder {
    @Override
    public void field() {
        System.out.println("PureBatsman is fielding");
    }

    @Override
    public void bat() {
        System.out.println("PureBatsman is batting");
    }
}
