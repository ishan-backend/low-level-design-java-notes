package chess;

import java.util.Map;

public abstract class ChessPlayer extends Player{
    private final Map<PieceName, ChessPiece> chessPieceMap;
    private final ChessBoard chessBoard;

    public ChessPlayer(Map<PieceName, ChessPiece> chessPieceMap, ChessBoard chessBoard, String name) {
        super(name);
        this.chessPieceMap = chessPieceMap;
        this.chessBoard = chessBoard;
    }

    public Map<PieceName, ChessPiece> getChessPieceMap() {
        return chessPieceMap;
    }

    public ChessBoard getChessBoard() {
        return chessBoard;
    }

//    @Override
//    public Move makeMove() {
//        // makeMove() can happen via AI or Human, writing if/else doesn't make sense
//        // So make this class as abstract
//        // Concrete Class HumanChessPlayer, ComputerChessPlayer - which can implement this method
//        return null;
//    }

    public ChessPiece getPiece(PieceName pieceName) {
        if(!chessPieceMap.containsKey(pieceName)) {
            throw new IllegalArgumentException("invalid argument");
        }
        return this.chessPieceMap.get(pieceName);
    }
}
