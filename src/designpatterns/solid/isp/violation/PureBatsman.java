package designpatterns.solid.isp.violation;

public class PureBatsman implements Player{
    @Override
    public void bat() {
        System.out.println("Player is batting");
    }
    @Override
    public void ball(){
        throw new RuntimeException("PureBatsman cannot ball");
    }
    @Override
    public void keep(){
        throw new RuntimeException("PureBatsman cannot keep");
    }
    @Override
    public void field(){
        throw new RuntimeException("PureBatsman cannot field");
    }
}
