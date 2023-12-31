package inMemoryMySql.constraint;

import inMemoryMySql.data.Column;
import inMemoryMySql.data.Row;
import inMemoryMySql.data.Table;

import java.util.PriorityQueue;
import java.util.Set;

public class PrimaryKeyConstraint implements IConstraint{
    private final Table table;
    private final Set<Column> primaryKeys;

    public PrimaryKeyConstraint(Table table, Set<Column> primaryKeys) {
        this.table = table;
        this.primaryKeys = primaryKeys;
    }

    @Override
    public void applyOnInsertRow(Row insertRow) {
        // if new row has to be inserted, we need to check if atleast one of primary key columns need to be different from all other rows of table
        for(Row row: table.getRows()) {
            boolean allMatch = true;
            for(Column col: primaryKeys) {
                if(!row.get(col).equals(insertRow.get(col))) {
                    allMatch = false;
                }
            }
            if(allMatch)
                throw new RuntimeException("primary key constraint violated");
        }
    }

    @Override
    public void applyOnUpdateRow(Row updateRow) {
        for(Row row: table.getRows()) {
            boolean allMatch = true;
            for(Column col: primaryKeys) {
                if(!row.get(col).equals(updateRow.get(col))) {
                    allMatch = false;
                }
            }
            if(allMatch)
                throw new RuntimeException("primary key constraint violated");
        }
    }

    @Override
    public void applyOnDeleteRow(Row deleteRow) {
        // no action
    }
}
