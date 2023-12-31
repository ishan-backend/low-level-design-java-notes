package inMemoryMySql.data;

import inMemoryMySql.constraint.IConstraint;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Table {
    private final String name; // as name won't change, it is kept private final
    private final Set<Column> columns;
    private final List<Row> rows;
    private final List<IConstraint> constraints;

    public Table(String name, Set<Column> columns) {
        this.name = name;
        this.columns = columns;
        this.constraints = new ArrayList<>();
        this.rows = new ArrayList<>();
    }

    public void addColumn(String  name, String description) {

    }

    public void deleteColumn(String name) {

    }

    public void addRow(Row row) {
        for(IConstraint constraint: constraints) {
            constraint.applyOnInsertRow(row);
        }
        this.rows.add(row);
    }

    public void deleteRow(Row row) {
        if(!this.rows.contains(row)) {
            throw new RuntimeException("row doesn't exist");
        }

        for(IConstraint constraint: constraints) {
            constraint.applyOnDeleteRow(row);
        }

        this.rows.remove(row);
    }

    public List<Row> getRows() {
        return this.rows;
    }

    public List<IConstraint> getConstraints() {
        return constraints;
    }

    public void addConstraint(IConstraint constraint) {
        this.constraints.add(constraint);
    }
}
