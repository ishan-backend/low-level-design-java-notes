package inMemoryMySql.constraint;

import inMemoryMySql.data.Row;
import inMemoryMySql.data.Table;

import java.util.List;
import java.util.Objects;

public class ParentForeignKeyConstraint implements IConstraint{
    private final Table parentTable;
    private final List<ColumnMapping> columnMappings;

    public ParentForeignKeyConstraint(Table parentTable, List<ColumnMapping> columnMappings) {
        this.parentTable = parentTable;
        this.columnMappings = columnMappings;
    }

    @Override
    public void applyOnInsertRow(Row insertRow) {
        // when inserting a new mark, we need to check if either one row exists of Student in student table
        // go to parent table, iterate over all rows and check if columnMapping exactly exists for one of the rows or not
        for(Row row: parentTable.getRows()) {
            boolean allMatch = true;
            for(ColumnMapping columnMapping: columnMappings) {
                if(!Objects.equals(row.get(columnMapping.getForeignTableCol()), insertRow.get(columnMapping.getCurrentTableCol()))) {
                    allMatch = false;
                }
            }

            if(allMatch)
                return;
            throw new RuntimeException("parent foreign key constraint violated");
        }
    }

    @Override
    public void applyOnUpdateRow(Row updateRow) {
        // same as above
        for(Row row: parentTable.getRows()) {
            boolean allMatch = true;
            for(ColumnMapping columnMapping: columnMappings) {
                if(!Objects.equals(row.get(columnMapping.getForeignTableCol()), updateRow.get(columnMapping.getCurrentTableCol()))) {
                    allMatch = false;
                }
            }

            if(allMatch)
                return;
            throw new RuntimeException("parent foreign key constraint violated");
        }
    }

    @Override
    public void applyOnDeleteRow(Row deleteRow) {
        // no action
    }
}
