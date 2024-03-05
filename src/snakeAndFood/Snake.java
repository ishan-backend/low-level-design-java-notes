package snakeAndFood;

import java.util.LinkedList;

public class Snake {
    private LinkedList<Cell> snakeBody = new LinkedList<>();
    private Cell snakeHead;

    public Snake(Cell initPos) {
        this.snakeHead = initPos;
        this.snakeBody.add(initPos);
        initPos.setCellType(CellType.SNAKE_BODY);
    }

    public void move(Cell nextCell) {
        System.out.println("Snake is moving to" + nextCell.getRow() + " " + nextCell.getCol());
        Cell tail = snakeBody.removeLast();
        tail.setCellType(CellType.EMPTY);

        snakeHead = nextCell;
        snakeBody.addFirst(nextCell);
        snakeHead.setCellType(CellType.SNAKE_BODY);
    }

    public boolean checkCrash(Cell nextCell) {
        System.out.println("Going to check for Crash");
        for (Cell cell : snakeBody) {
            if (cell == nextCell) {
                return true;
            }
        }

        return false;
    }

    public void grow(Cell nextCell) {
        snakeBody.addFirst(nextCell);
    }

    public LinkedList<Cell> getSnakeBody() {
        return snakeBody;
    }

    public void setSnakeBody(LinkedList<Cell> snakeBody) {
        this.snakeBody = snakeBody;
    }

    public Cell getSnakeHead() {
        return snakeHead;
    }

    public void setSnakeHead(Cell snakeHead) {
        this.snakeHead = snakeHead;
    }
}
