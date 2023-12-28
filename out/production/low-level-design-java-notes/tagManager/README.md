**Design for discussion forum of Reddit/Programming courses/Udemy etc**

**Requirements**:
1. Support tags (a string) that can be added, while asking questions/doubts.
    e.g. Math, Runtime error, Go, Knapsack
2. We want to create a system that manipulates this datastore of strings, following are the operations we want to support:
   1. Delete a tag
   2. Delete all tags that matches a pattern
   3. Insert a new tag
   4. Update a tag
   5. Update all instances of a tag to new tag
   6. Merges all common theme tags to a common tag (e.g. math, mathematics, Maths -> Math)

**Implementation Flow Gist**:
1. Start with TagManager class and appropriate methods needed
2. Identify the use of Command pattern
   1. Write interface with execute method
   2. Write concrete implementations for C, U, D operations and its permutations
   3. We want to keep execute method implementation inside concrete classes to be as abstracted as possible
3. Identify to write receiver classes which contains actual logic and DB interaction for individual concrete classes
4. Write Data Store Class to mock DB interaction
5. Once Data Store and Receiver are implemented, lets complete concrete implementations of command pattern
6. Refactor TagManager class:
   1. depends on Command polymorphic type, inject it in constructor
   2. add changeTags() method, which calls execute from command pattern depending on injected command concrete type from client
7. Write API layer for common delete API, create ENUM class for partial, perfect
8. Use Factory pattern for creational responsibility for Command - CommandFactory class
9. Write main class

**Improvements**:
1. In concrete implementations, you can add interface for receiver class instead -> so that, execute() method can then function differently on basis of different combinations
2. Abstracting out commands in interface makes it re-usable for some new product tomorrow, lets say ProductManager class, which would like to update it as master user
   1. Thus promoting re-usability
   2. interface for receiver class -> will make implementation conducive for tagManager, productManager etc.