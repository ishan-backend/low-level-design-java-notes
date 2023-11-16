package chess;

public class Pawn implements ChessPiece{
    private final Color color;
    private final PieceName name;
    private boolean isDead; // can be changed, hence not final

    public Pawn(Color color, PieceName name, boolean isDead) {
        this.color = color;
        this.name = name;
        this.isDead = isDead;
    }

    @Override
    public void move(ChessBoard chessBoard, ChessCell source, ChessCell destination) {

    }

    @Override
    public boolean isDead() {
        return isDead;
    }

    @Override
    public void setDead(boolean isDead) {
        this.isDead = isDead;
    }

    @Override
    public PieceName getName() {
        return this.name;
    }
}
