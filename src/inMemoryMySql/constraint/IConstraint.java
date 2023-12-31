package inMemoryMySql.constraint;

import inMemoryMySql.data.Row;

public interface IConstraint {
    void applyOnInsertRow(Row insertRow);
    void applyOnUpdateRow(Row updateRow);
    void applyOnDeleteRow(Row deleteRow);
}
