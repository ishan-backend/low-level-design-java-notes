package chess.board.chessboard.piece;

import chess.board.chessboard.ChessBoard;
import chess.board.chessboard.ChessCell;

public interface IChessPiece {
    void move(ChessCell source, ChessCell destination, ChessBoard board);
    boolean isDead();
    void setDead(boolean dead);
    PieceName getName();
}
