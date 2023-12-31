package inMemoryMySql.constraint;

import inMemoryMySql.data.Column;

public class ColumnMapping {
    private final Column foreignTableCol;
    private final Column currentTableCol;

    public ColumnMapping(Column foreignTableCol, Column currentTableCol) {
        this.foreignTableCol = foreignTableCol;
        this.currentTableCol = currentTableCol;
    }

    public Column getCurrentTableCol() {
        return currentTableCol;
    }

    public Column getForeignTableCol() {
        return foreignTableCol;
    }
}
