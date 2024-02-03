package chess.board.chessboard;

import chess.board.IBoard;
import chess.move.Move;

import java.util.ArrayList;
import java.util.List;

/*
     ChessBoard - 2D list/grid of ChessCell
*/
public class ChessBoard implements IBoard {
    private final List<List<ChessCell>> cells; // ChessBoard has concrete classes ChessCell which is fine because chessBoard only needs to know of ChessCells and not any other cell
    // static fields - same across all instances of this class
    private static final int rowCount = 8;
    private static final int colCount = 8;

    public ChessBoard() {
        // initialises 8x8 chess board
        this.cells = new ArrayList<>();
        for(int i=0; i<rowCount; i++) {
            List<ChessCell> chessCells = new ArrayList<>();
            for(int j=0; j<colCount; j++) {
                chessCells.add(new ChessCell(i, j));
            }
            this.cells.add(chessCells);
        }
    }

    @Override
    public void display() {

    }

    @Override
    public void applyMove(Move move) {

    }
}
