package inMemoryMySql.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
    private static Database INSTANCE;
    private final Map<String, Table> tables;
    private Database(){
        this.tables = new HashMap<>();
    }

    public static Database getINSTANCE() {
        if(INSTANCE == null)
            return new Database();
        return INSTANCE;
    }

    public Table getTable(String tableName) {
        if(!tables.containsKey(tableName)) {
            throw new RuntimeException("invalid table name");
        }
        return tables.get(tableName);
    }

    public void putTable(String tableName, Table table) {
        if(tables.containsKey(tableName)) {
            throw new RuntimeException("table already exists");
        }
        tables.put(tableName, table);
    }

    public void deleteTable(String tableName) {
        if(!tables.containsKey(tableName)) {
            throw new RuntimeException("tableName does not exist");
        }
        tables.remove(tableName);
    }

    public List<Table> getAllTables() {
        List<Table> allTables = new ArrayList<>();
        for(Map.Entry<String, Table> entry: this.tables.entrySet()) {
            allTables.add(entry.getValue());
        }
        return allTables;
    }
}
