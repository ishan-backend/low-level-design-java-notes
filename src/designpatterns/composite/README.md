When we have tree like structure, object inside object
https://www.youtube.com/watch?v=FLkCkUY7Wu0

1. Design File System
    * can have File/Directory
    * Directory can have File/Directory

    * composite design pattern solves if-else check in list of objects before executing ls(), at type casting instanceOf 
    * create interface FileSystem interface with ls() method
      * two implementation:
        * File (leaf of our tree) -> has simple ls method
        * Directory (intermediate node of our tree is composite object) -> contains List<FileSystem>
2. 