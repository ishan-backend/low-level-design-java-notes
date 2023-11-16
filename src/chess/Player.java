package chess;

public abstract class Player {
    private final String name;
    protected Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract Move makeMove(); // different players make this move in different function, this will return a move which will be applied to the board.
}
