package chess;

public interface ChessPiece {
    void move(ChessBoard chessBoard, ChessCell source, ChessCell destination);
    boolean isDead();
    void setDead(boolean isDead);
    PieceName getName();
}
