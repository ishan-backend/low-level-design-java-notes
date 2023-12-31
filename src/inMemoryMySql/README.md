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
2. 