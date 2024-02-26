package tictactoe;

public class Player {
    private String playerName;
    private int playerId;
    private String address;
    private int ranking;
    private char playerSymbol; // X / O

    public Player(String playerName, int playerId) {
        this.playerName = playerName;
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerId() {
        return playerId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getRanking() {
        return this.ranking;
    }

    public void setPlayerSymbol(char playerSymbol) {
        this.playerSymbol = playerSymbol;
    }

    public char getPlayerSymbol() {
        return this.playerSymbol;
    }
}
