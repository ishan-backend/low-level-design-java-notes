package chess;

import java.util.Queue;

public abstract class BoardGame {
    // we can different type of board games like snake and ladder, chess
    private final Board board;
    // we can have a board game which will support many player
    // players will play turn by turn - so we can use queue data structure
    private final Queue<Player> players;

    public BoardGame(Board board, Queue<Player> players) {
        this.board = board;
        this.players = players;
    }

    public void startGame() { // will run infinitely
        while(true) {
            Player currentPlayer = players.poll();
            Move move = currentPlayer.makeMove(); // move can be imagined as moving from source to destination
            // Move can be a concrete class containing pair(source, destination) where source = (x, y)
            // using concrete type is ok, if that is not going to vary a lot in future
            // if in future, we want move to be abstract with additional changes, but now we will keep it concrete.
            // Use SOLID with common sense

            board.applyMove(move);
            // after move is applied, check if game is now over, since we want to break this loop
            // abstract class and its impl for breaking the game now on over (chess, snake and ladder)
            if(isOver()) {
                System.out.println("Game over" + currentPlayer.getName() + " is winner");
                break;
            }

            players.add(currentPlayer); // to continue play if not break
        }
    }

    public abstract boolean isOver();
}
