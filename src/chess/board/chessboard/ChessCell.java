package chess.board.chessboard;

import chess.board.chessboard.piece.IChessPiece;

import java.util.Optional;

public class ChessCell { // concrete class
    private final int x;
    private final int y;

    // ChessPiece will be abstract type, can be private but not final
    // since piece in a cell can change and be present/absent
    // null pointer exception handling if no such object is available - Optional , at get time - chessPiece.isPresent().get()
    private Optional<IChessPiece> chessPiece;

    public ChessCell(int x, int y) {
        this.x = x;
        this.y = y;
        this.chessPiece = Optional.empty();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setChessPiece(Optional<IChessPiece> chessPiece) { // as game progresses, setChessPiece changes piece is the cell
        this.chessPiece = chessPiece;
    }
}
