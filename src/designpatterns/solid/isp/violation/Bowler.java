package designpatterns.solid.isp.violation;

public class Bowler implements Player{
    @Override
    public void bat() {
        throw new RuntimeException("Bowler cannot bat");
    }
    @Override
    public void ball(){
        System.out.println("Bowler can ball");
    }
    @Override
    public void keep(){
        throw new RuntimeException("Bowler cannot keep");
    }
    @Override
    public void field(){
        System.out.println("Bowler can field");
    }
}
