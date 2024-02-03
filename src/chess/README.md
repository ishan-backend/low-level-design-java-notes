**Let’s design the Chess. The requirements are**:

* we want to design a simple two player chess game where players take their moves turn by turn.
* there must be option for human player and computer player for both players
* we want to implement the simple and basic rules of chess in our game.
  * The chess contains 16 pieces for each player , 8 pawns , 2 rooks , 2 bishops , 2 knights , 1 queen and 1 king.
  * The movement of each piece is as follows
    ```text
    Pawn moves 1 step in a straight line . and initially it can take 2 steps. Pawn captures or attacks in a diagonal step.
    Rook moves in same row and same column and can captures any piece in its way
    Bishop can only move in diagonals and can capture every piece of opponent in its way
    Queen uses a combination of rook and bishop , hence she can move in any diagonals or in any row or column..
    Knight moves in a L - shape , means it moves 2 steps in straight direction the it moves 1 step in perpendicular direction.
    Knight is the only piece which can jump over the other pieces.
    King can move in any direction But only 1 step
    ```

4. We will design our chessboard class  in such a manner so that it can also be extensible to other board games such as snake and ladder.

5. Different board games require different boards. We should make an interface Board for that.This follows dependency inversion principle.

6. Our  base  class name is BoardGame.Our interface Board contains different methods i.e. display() and applyMove()

7. As we want to make it extensible to other board games hence we should not have entity name chessPlayer here instead of that we should have simple Player entity here and this Player should be abstract too.

8. Player interface will initially contain string name , constructor , abstract makeMove method of type Move and a getter for getting name of the player.

9. Since we can have different BoardGame hence it may be possible to have more than 2 players . So we will use the queue Data structure as a list of players taking turns. Player at the front will have the first turn and after its turn over it will be pushed to the back of the queue.

10. In our BoardGame class we will implement a function named startGame() which will run an infinite loop for us and inside that loop we will take players turn by turn from the queue.and each player will make a Move.

11. Move is a concrete class which contains logic of moving a player from start state to goal state.Since our Move class won’t be changing frequently in future hence it is perfectly OK to make it concrete.

12. Now to end the game we should check some winning conditions. But for different games , there are different winning conditions. Hence to solve this problem we can make our BoardGame class abstract and chess will be a children of this abstract class. This will also contain the abstract method isOver() which will be used by its child class.

13. The body of the startGame() method is so generic that it can be used by almost every boardGame hence this is the reason we made our BoardGame class as abstract

14. Now we will create a concrete Chess class which is an extension ( child ) of the BoardGame abstract class.

15. Since our chessBoard consists of a 2-D grid of ChessCell. We will create a 2-D List of chessCell for that. Where chessCells is a Class consisting of final int x ,final int y and an Optional<ChessPiece> chesspiece. Since this chesspiece can be NULL as it may be possible that there is no chessPiece present at that particular cell hence we will use JAVA inbuilt Optional type.

16. We will now create an interface ChessPiece which will define the type of chess piece i.e. Rook , Knight , Pawn etc.

17. ChessPiece interface will contain move() function , isDead() variable , setDead() method getname() method of type pieceName , where pieceName is an ENUM.

18. Now we will implement a class for each piece i.e. pawn , rook etc .

19. We will also have a ChessPlayer class which is extended from Player class .This class will contain a HashMap<pieceName, ChessPiece> pieces for taking a record of all pieces a player has and also a method getPiece().

20. Since our player can be human or computer and both of these may have different algorithms to make a move hence we have to write some if-else conditions for that which is not a good practice

21. To solve the above problem what we can do is that we can make our ChessPlayer class as abstract and then we can extend ChessPlayer class to HumanChessPlayer and Computer ChessPlayer classes.

22. In both of the above classes they will contain a method named makeMove() to perform the move on the chessBoard.

23. One good Observation is that to make a Move whether it is a Human or Computer they must have to take a look on the ChessBoard. Hence in our ChessPlayer class we will introduce a new private final variable named chessboard of type ChessBoard. And also implement a getter for that.

24. Now for further implementation of above logic please refer to our code shared within the video.