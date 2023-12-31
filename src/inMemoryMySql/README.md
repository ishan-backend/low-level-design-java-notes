**Requirements**:
* In-memory: keep everything on RAM, not write logic of persisting on hard-disk
* mySql: Database and Tables, relationships, queries.

* Concrete Requirements:
  * Exactly 1 Database with multiple tables
  * Table is composed of rows and columns
  * Columns will be stored in form of Strings (int, float etc in form of Strings)
  * Create/Delete a table
  * Add/Delete columns from table
  * Tables should have constraints, since this is relational DBMS (extensible): [Constraints prevent corrupted data]
    * (Primary key constraint (1/multiple columns uniquely identifying row in table))
    * Foreign key constraint (a column of particular row is used to reference another row of other table)
      * Inserting
      * Deleting - first delete from child table, then parent table
    * NOT NULL
    * UNIQUE
  * Selection (select query) / Updating of rows in certain table under certain criteria (filter(s) / multiple)
    * Filter by compare column value to a constant
      * Comparison operator can be > , < ,  = ,  != etc
      * Multiple filters are allowed:
        * joined by using && / ||
      * Brackets
        * Outputs depend on bracket placement
  * Joins and Aggregations (Ignored)

**Implementation Steps**:

**Databases and Tables**:
1. Create class Database. Since we want to have only one Database ever declared, we can use Singleton pattern.
   1. private constructor
   2. private static instance
   3. public static getter for instance
2. Database has multiple tables:
   1. for quicker access, we can keep map[tableName]Table, instead for using list
      1. insert map in constructor of database
      2. make its get method with table name and create its class
   2. putTable method: save a table
   3. deleteTable method
3. Create class Table:
   1. addRow, deleteRow, addColumn, deleteColumn
   2. Data classes for row and column
4. Constraint:
   1. While adding row, add constraint
   2. multiple types of constraints - so abstraction ; following SRP - that table should not worry about constraint
   3. add abstraction in Table
   4. on different operations in table, we might need to trigger operations of constraint
   5. e.g any mutation of table, we need to trigger all constraints
   6. Design choice: first add row then check for constraint? or vice-versa , we go with second one.
   7. Concrete constraints:
      1. Primary Key constraint:
         1. is applied on a table
         2. consists of column(s)
      2. Foreign Key constraint:
         1. ParentForeignKey constraint - Mark has parent Student, we are implementing for Mark table
         2. Column mapping from parent table to child table
            1. Create ColumnMapping class
         3. A table might have foreign key relationship with B, C tables, so as many objects of Constraint need to created for each pair
      3. 