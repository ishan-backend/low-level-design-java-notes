package chess;

public interface Board{
    void applyMove(Move move); // applyMove happens differently for different games
    void display(); // displays board game
}
