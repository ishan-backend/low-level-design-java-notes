package chess.chess;

import chess.BoardGame;

/*
    When Chess is instantiated it will be passed:
    - two players
    - chess board i.e. ChessBoard implements IBoard
*/
public class Chess extends BoardGame {
    @Override
    public boolean isOver() {
        return false;
    }
}
