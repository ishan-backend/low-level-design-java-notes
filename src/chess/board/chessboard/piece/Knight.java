package chess.board.chessboard.piece;

import chess.board.chessboard.ChessBoard;
import chess.board.chessboard.ChessCell;

public class Knight implements IChessPiece{
    @Override
    public void move(ChessCell source, ChessCell destination, ChessBoard board) {

    }

    @Override
    public boolean isDead() {
        return false;
    }

    @Override
    public void setDead(boolean dead) {

    }

    @Override
    public PieceName getName() {
        return null;
    }
}
