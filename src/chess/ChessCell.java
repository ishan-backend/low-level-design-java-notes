package chess;

import java.util.Optional;

public class ChessCell {
    private final int x;
    private final int y;
    private Optional<ChessPiece> chessPiece;
    // ChessPiece is a polymorphic type and can have many children
    // All of them will move but move in a different way
    // All of them might be dead, at some point

    public ChessCell(int x, int y) {
        this.x = x;
        this.y = y;
        chessPiece = Optional.empty();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Optional<ChessPiece> getChessPiece() {
        return chessPiece;
    }

    public void setChessPiece(Optional<ChessPiece> chessPiece) {
        this.chessPiece = chessPiece;
    }
}
