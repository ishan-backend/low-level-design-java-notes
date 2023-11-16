package chess;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Chess extends BoardGame{
    // chessboard + two players
    // Player player1, player2;  Player is abstract class for any game, and should not worry about chess pieces which are specific to chess
    // Player should be extensible to ChessPlayer, SnakeAndLadderPlayer etc

    // player1, player2 have their own map of ChessPieces
    ChessPlayer player1, player2; // reason why we are keeping ChessPlayer player1, player2 here when BoardGame has Queue<Player> players
    // is - Queue<Player> is higher polymorphic type and we cannot call getPiece() on it
    // ChessBoard chessBoard; - we don't need it because we are already storing it on BoardGame level and there's no method required specifically here on it

    public Chess(ChessPlayer player1, ChessPlayer player2, ChessBoard chessBoard) {
        super(chessBoard, new ArrayDeque<Player>(
                Arrays.asList(player1, player2)
        )); // calls parent constructor
        this.player1 = player1;
        this.player2 = player2;

        // prepareBoard is a private method which arranges/initialises all board with chess pieces for player 1 and 2
        prepareBoard(this.player1, this.player2, chessBoard);
    }

    @Override
    public boolean isOver() {
        // one of the two player's king is dead
        // somehow get chessPiece of player1/player2 and check isDead() status
        return player1.getPiece(PieceName.KING).isDead() || player2.getPiece(PieceName.KING).isDead();
    }

    private void prepareBoard(ChessPlayer player1, ChessPlayer player2, ChessBoard chessBoard) {
        placePawns(1, chessBoard, player1);
        placePawns(6, chessBoard, player2);
        placeRooks(0, chessBoard, player1);
        placeRooks(7, chessBoard, player2);
        placeKnights(0, chessBoard, player1);
        placeKnights(7, chessBoard, player2);
        placeBishops(0, chessBoard, player1);
        placeBishops(7, chessBoard, player2);
        placeKing(0, chessBoard, player1);
        placeKing(7, chessBoard, player2);
        placeQueen(0, chessBoard, player1);
        placeQueen(7, chessBoard, player2);
    }

    private void placePawns(Integer row, ChessBoard chessBoard, ChessPlayer player) {
        List<PieceName> pieceNames = Arrays.asList(PieceName.PAWN1, PieceName.PAWN2, PieceName.PAWN3, PieceName.PAWN4, PieceName.PAWN5, PieceName.PAWN6, PieceName.PAWN7, PieceName.PAWN8);
        int col = 0;
        for(PieceName pieceName : pieceNames) {
            chessBoard.
        }
    }
}
