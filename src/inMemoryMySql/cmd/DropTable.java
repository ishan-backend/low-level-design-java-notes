package inMemoryMySql.cmd;

import inMemoryMySql.data.Database;
import inMemoryMySql.data.Table;

// DROP TABLE <TABLENAME>
public class DropTable implements ISqlCommand{
    private final String tableName;

    public DropTable(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public void execute() {
        Database db = Database.getINSTANCE();
//        Table tableToBeDeleted = db.getTable(tableName);
        // drop the table only after checking all the constraints - foreign key from both sides


        db.deleteTable(tableName);
        System.out.println("dropped the table successfully");
    }
}
