package chess;

import chess.board.IBoard;
import chess.move.Move;
import chess.player.IPlayer;

import java.util.Queue;

/*
     BoardGame - is abstract instead of other polymorphic type i.e. interface
     using abstract class, we are able to write body of method startGame() inside this class
     isOver() strategy will be different for different chess games.
*/
public abstract class BoardGame {
    private final IBoard board; // abstract - DIP
    // we can have boardGame which can have more than two players
    // we want to support players move turn by turn - DS (Queue)
    private final Queue<IPlayer> players;

    public BoardGame(IBoard board, Queue<IPlayer> players) {
        this.board = board;
        this.players = players;
    }

    // Major function - to start the game
    public void startGame() {
        // infinite while loop
        while(true){
            IPlayer currentPlayer = players.poll();
            Move move = currentPlayer.makeMove(); // currentPlayer wants to make move (source pair -> destination pair)

            // apply move to board
            board.applyMove(move);
            // check if game is already over and end game
            // different boardgames will have different conditions for when game is over
            // so BoardGame can be made abstract class, and children of this class (Chess, SnakeLadder) will implement it
            if(isOver()) {
                System.out.println("Game over!! " + currentPlayer.getName() + " is winner!!");
                break;
            }

            players.add(currentPlayer);
        }
    }

    public abstract boolean isOver();
}
