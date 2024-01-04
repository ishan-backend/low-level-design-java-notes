package designpatterns.solid.isp.violation;

public class CricketGameHelper {
    public void bat(Player player) {
        player.bat();
    }

    public void ball(Player player) {
        if(player instanceof Bowler)
            player.ball();
    }

    public void keep(Player player) {
        if(player instanceof Bowler) // Wicketkeeper
            player.keep();
    }

    public void field(Player player) {
        if(player instanceof Bowler) // Wicketkeeper
            return;
        player.field();
    }
}
