package chess.board;

import chess.move.Move;

public interface IBoard {
    void display(); // displays the current board for different natures of games
    void applyMove(Move move); // can be implemented differently by ChessBoard, SnakesLadders
}
