package inMemoryMySql.constraint;

import inMemoryMySql.data.Row;
import inMemoryMySql.data.Table;

import java.util.List;

public class ChildForeignKeyConstraint implements IConstraint{
    private final Table childTable;
    private final List<ColumnMapping> columnMappings;

    public ChildForeignKeyConstraint(Table childTable, List<ColumnMapping> columnMappings) {
        this.childTable = childTable;
        this.columnMappings = columnMappings;
    }

    @Override
    public void applyOnInsertRow(Row insertRow) {
        // no action
    }

    @Override
    public void applyOnUpdateRow(Row updateRow) {
        // some checks
    }

    @Override
    public void applyOnDeleteRow(Row deleteRow) { // delete student
        // if we try to delete a student, we need to check that that student should not have any reference in marks table
        // for every row in marks
        for(Row row: childTable.getRows()) {
            boolean allMatch = true;
            for(ColumnMapping columnMapping: columnMappings) { // group of columns ki foreign key between two tables
                // compare foreign key individual col values between mark and student table
                if(row.get(columnMapping.getForeignTableCol()) != deleteRow.get(columnMapping.getCurrentTableCol())) {
                    allMatch = false;
                }
            }

            if(allMatch)
                throw new RuntimeException("child foreign key violated"); // if in any row of mark, every column matches exactly, constraint is violated
        }
    }
}
