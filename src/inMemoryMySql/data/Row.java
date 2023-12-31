package inMemoryMySql.data;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Row {
    private final Map<Column, String> data;

    public Row(Set<Column> columns) {
        this.data = new HashMap<>();
        for(Column col: columns) {
            this.data.put(col, null);
        }
    }

    public void put(Column column, String val) {
        if(!data.containsKey(column)) {
            throw new RuntimeException("invalid column; does not exist");
        }
        this.data.put(column, val);
    }

    public String get(Column column) {
        if(!data.containsKey(column)) {
            throw new RuntimeException("invalid column; does not exist");
        }
        return this.data.get(column);
    }

    public void printRow() {
        for(Map.Entry<Column, String> row: data.entrySet()) {
            System.out.println(row.getKey().getName() + ": " + row.getValue());
        }
    }
}
