package chess.board.chessboard.piece;

import chess.board.chessboard.ChessBoard;
import chess.board.chessboard.ChessCell;

public class Pawn implements IChessPiece { // Pawn / ChessPiece will have colors, a name and whether its dead or not
    private final Colors color;
    private final PieceName name;
    private boolean isDead;

    public Pawn(Colors color, PieceName name) {
        this.color = color;
        this.name = name;
        this.isDead = false;
    }

    @Override
    public void move(ChessCell source, ChessCell destination, ChessBoard board) {

    }

    @Override
    public boolean isDead() {
        return isDead;
    }

    @Override
    public void setDead(boolean dead) {
        this.isDead = dead;
    }

    @Override
    public PieceName getName() {
        return this.name;
    }
}
