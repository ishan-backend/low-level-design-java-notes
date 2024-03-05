package snakeAndFood;

import java.util.Scanner;

public class Game {
    private Board board;
    private Snake snake;
    private boolean gameOver;
    private int direction;
    // score

    public static final int DIRECTION_NONE = 0, DIR_UP = 1, DIR_DOWN = 2, DIR_RIGHT = 4, DIR_LEFT = 3;

    public Game(Board board, Snake snake) {
        this.board = board;
        this.snake = snake;
    }

    // getters and setters
    public void setBoard(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Snake getSnake() {
        return snake;
    }

    // update game
    private Cell getNextCell(Cell currentPosition)
    {
        System.out.println("Going to find next cell");
        int row = currentPosition.getRow();
        int col = currentPosition.getCol();

        if (direction == DIR_RIGHT) {
            col++;
        }
        else if (direction == DIR_LEFT) {
            col--;
        }
        else if (direction == DIR_UP) {
            row--;
        }
        else if (direction == DIR_DOWN) {
            row++;
        }

        Cell nextCell = board.getCells()[row][col];
        return nextCell;
    }

    public void update() {
        System.out.println("Going to update the game");
        if (!gameOver) {
            if (direction != DIRECTION_NONE) {
                Cell nextCell = getNextCell(this.snake.getSnakeHead());

                if (snake.checkCrash(nextCell)) {
                    setDirection(DIRECTION_NONE);
                    gameOver = true;
                } else {
                    snake.move(nextCell);
                    if (nextCell.getCellType() == CellType.FOOD) {
                        snake.grow(nextCell);
                        board.generateFood();
                    }
                }
            }
        }
    }

    // main
    public static void main(String[] args) {
        System.out.println("Going to start game");
        Scanner scanner = new Scanner(System.in);

        Cell initPos = new Cell(0, 0);
        Board board = new Board(10, 10);
        Snake initSnake = new Snake(initPos);
        Game newGame = new Game(board, initSnake);
        newGame.gameOver = false;
        newGame.direction = DIR_RIGHT;

        while(!newGame.isGameOver()) {
            System.out.print("Enter direction (1: UP, 4: RIGHT, 2: DOWN, 3: LEFT): ");
            int directionInput = scanner.nextInt();
            // check current pos and if it lies on boundary throw exception

            newGame.direction = directionInput;

            newGame.update();
            if (newGame.gameOver) {
                break;
            } else {
                newGame.board.generateFood();
            }
        }

//        for (int i = 0; i < 5; i++) {
//            if (i == 2)
//                newGame.board.generateFood();
//
//            newGame.update();
//            if (i == 3)
//                newGame.direction = DIR_RIGHT;
//            if (newGame.gameOver)
//                break;
//        }
    }

}
