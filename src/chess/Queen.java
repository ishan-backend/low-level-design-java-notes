package chess;

public class Queen implements ChessPiece{
    @Override
    public void move(ChessBoard chessBoard, ChessCell source, ChessCell destination) {
        // move functionality for Queen
        // will check if some opponents pieces lie in middle
        // can kill that piece and stop there
        // investigate other cells in between the source and destination so ChessBoard chessBoard is required
    }

    @Override
    public boolean isDead() {
        return false;
    }

    @Override
    public void setDead(boolean isDead) {

    }

    @Override
    public PieceName getName() {
        return null;
    }
}
