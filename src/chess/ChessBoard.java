package chess;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ChessBoard implements Board {
    private final List<List<ChessCell>> cells;
    // only ChessBoard needs to know of ChessCell, so ChessCell is a concrete type
    private static final int rowCount = 8;
    private static final int columnCount = 8;

    public ChessBoard() { // will initialise 8x8 cells
        this.cells = new ArrayList<>();

        for(int i=0; i<rowCount; i++) {
            List<ChessCell> chessCells = new ArrayList<>();
            for(int j=0; j<columnCount; j++) {
                chessCells.add(new ChessCell(i, j));
            }

            this.cells.add(chessCells);
        }
    }

    @Override
    public void applyMove(Move move) {
        ChessCell sourceCell = getCell(move.getSource());
        ChessPiece chessPiece = sourceCell.getChessPiece().get();
        chessPiece.move(this, sourceCell, getCell(move.getDestination()));

    }

    @Override
    public void display() {
        for(int r=0; r<rowCount; r++) {
            for(int c=0; c<columnCount; c++) {
                Pair p = new Pair(r, c);
                Optional<ChessPiece> chessPiece = getCell(p).getChessPiece();
                if(!chessPiece.isPresent()) {
                    System.out.print("0 | ");
                } else {
                    System.out.print(chessPiece.get().getName() + " | ");
                }
            }
            System.out.println();
        }
    }

    public ChessCell getCell(Pair pair) {
        return this.cells.get(pair.getX()).get(pair.getY());
    }
}
