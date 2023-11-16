package chess;

import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class HumanChessPlayer extends ChessPlayer {
    public HumanChessPlayer(Map<PieceName, ChessPiece> chessPieceMap, ChessBoard chessBoard, String name) {
        super(chessPieceMap, chessBoard, name);
    }

    @Override
    public Move makeMove() {
        getChessBoard().display();
        int x, y;
        Scanner scanner = new Scanner(System.in);
        x = scanner.nextInt(); y = scanner.nextInt();

        // call function inside chessBoard to getcell
        Optional<ChessPiece> chessPiece = getChessBoard().getCell(new Pair(x, y)).getChessPiece();
        // trivial check: if no piece is present in cell
        if(!chessPiece.isPresent())
            throw new RuntimeException("Invalid spot");
        // if it is other players piece from which you are trying to make move
        // chessPiece.get() : Optional to object of chessPiece type
        // then compare with ChessPiece of current player
        // call getPiece with the name of chessPiece say Rook, you have gotten to check if it's your Rook or others Rook
        if(!chessPiece.get().equals(getPiece(chessPiece.get().getName()))) {
            throw new RuntimeException("Invalid piece");
        }

        Pair source = new Pair(x, y);
        x = scanner.nextInt(); y = scanner.nextInt();
        Pair destination = new Pair(x, y);

        // put check for destination here similar to above
        // then call move
        return new Move(source, destination);
    }
}
