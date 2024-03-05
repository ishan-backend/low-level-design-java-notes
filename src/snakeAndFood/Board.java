package snakeAndFood;

public class Board {
    private final int ROW_COUNT, COL_COUNT;
    private Cell[][] cells;

    public Board(int rowCount, int colCount) {
        ROW_COUNT = rowCount;
        COL_COUNT = colCount;

        cells = new Cell[ROW_COUNT][COL_COUNT];
        for (int row = 0; row < ROW_COUNT; row++) {
            for (int column = 0; column < COL_COUNT; column++) {
                cells[row][column] = new Cell(row, column);
            }
        }
    }

    // after initialising board, init snake pos, then generate food
    public void generateFood() {
        System.out.println("Going to generate food");
        int row = 0, column = 0;
        while (true) {
            row = (int)(Math.random() * ROW_COUNT);
            column = (int)(Math.random() * COL_COUNT);

            if (cells[row][column].getCellType() != CellType.SNAKE_BODY)
                break;
        }

        cells[row][column].setCellType(CellType.FOOD);
        System.out.println("Food is generated at: " + row + " " + column);
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cell) {
        this.cells = cell;
    }
}
