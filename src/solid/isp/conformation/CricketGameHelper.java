package solid.isp.conformation;

public class CricketGameHelper {
    // this removes nasty instanceOf checks
    // just dependent on interfaces, not on inheritance - which leads to concrete implementations of methods (isp violation)
    public void bat(Player player) {player.bat();}
    public void bowl(Bowler bowler) {bowler.Bowl();}
    public void field(Fielder fielder) {fielder.field();}
    public void keeper(Keeper keeper) {keeper.keep();}
}
