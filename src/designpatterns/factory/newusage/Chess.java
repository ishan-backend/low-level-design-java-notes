package designpatterns.factory.newusage;

//public class Chess {
//    private final Board board;
//
//    public Chess() {
//        this.board = new Board();
//    }
//}

public class Chess {
    private final Board board; // if Board is an interface

    public Chess(Board board) { // polymorphic type
        this.board = board;
    }
}