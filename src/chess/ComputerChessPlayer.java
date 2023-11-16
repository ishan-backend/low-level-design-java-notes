package chess;

import java.util.Map;

public class ComputerChessPlayer extends ChessPlayer{
    public ComputerChessPlayer(Map<PieceName, ChessPiece> chessPieceMap, ChessBoard chessBoard, String name) {
        super(chessPieceMap, chessBoard, name);
    }

    @Override
    public Move makeMove() {
        return null;
    }
}
