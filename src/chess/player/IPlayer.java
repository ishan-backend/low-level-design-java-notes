package chess.player;

import chess.move.Move;

public abstract class IPlayer { // IPlayer is abstract class since it needs name attribute, and we have methods of this abstract class
    private final String name;

    protected IPlayer(String name) {
        this.name = name;
    }

    public abstract Move makeMove(); // e.g. your queen needs to move from point 1 to point 2, you want to take a ladder in snake and ladder

    public String getName() {
        return name;
    }
}
