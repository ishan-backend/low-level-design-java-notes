package inMemoryMySql.cmd;

import inMemoryMySql.data.Column;
import inMemoryMySql.data.Database;
import inMemoryMySql.data.Table;

import java.util.Set;

// CREATE TABLE <TABLENAME> LIST OF COLUMNS - for simplicity we can directly take set of columns
public class CreateTable implements ISqlCommand{
    private final String tableName;
    private final Set<Column> columns;

    public CreateTable(String tableName, Set<Column> columns) {
        this.tableName = tableName;
        this.columns = columns;
    }

    @Override
    public void execute() {
        Table table = new Table(tableName, columns);
        Database.getINSTANCE().putTable(tableName, table);
        // log of print statement when command is complete
        System.out.println("successfully created table");
    }
}
