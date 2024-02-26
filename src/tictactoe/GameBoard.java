package tictactoe;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GameBoard {
    char[][] board;
    int boardSize;
    Queue<Player> nextTurn;
    Scanner input;

    public GameBoard(int boardSize, Player[] players) { // assuming two players will come
        this.boardSize = boardSize;
        this.board = new char[(2*boardSize)-1][(2*boardSize)-1];
        initialiseBoard(this.board); // initialise board
        nextTurn = new LinkedList<>();
        nextTurn.offer(players[0]);
        nextTurn.offer(players[1]); // add two players to board
        input = new Scanner(System.in);
    }

    public void initialiseBoard(char[][] board) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(i%2 == 0 && j%2 == 1) board[i][j] = '|';
                if(i%2 == 1 && j%2 == 0) board[i][j] = '-';
                if(i%2 == 1 && j%2 == 1) board[i][j] = '+';
            }
        }
    }

    private void printBoard() {
        for(char[] row: board) {
            for(char col: row) {
                System.out.print(col);
            }
            System.out.println();
        }
    }

    public void startGame() {
        int count = 0;
        while(true) {
            count++;
            if(count == ((boardSize*boardSize)+1)) {
                System.out.println("match draw");
                break;
            }

            // if game is proceeding to next turn
            Player p = nextTurn.poll();
            // get user input - at what particular point, he wants to put mark
            int positionEntered = getUserInput(p);
            int row = 2*((positionEntered%boardSize == 0) ? (positionEntered/boardSize)-1 : (positionEntered/boardSize));
            int col = 2*((positionEntered%boardSize == 0) ? boardSize-1 : (positionEntered%boardSize)-1);
            board[row][col] = p.getPlayerSymbol();
            printBoard();
            System.out.println("Board after the move");

            if(count >= 2*boardSize && checkEndGame(p, row, col)) break; // check if game ends here

            nextTurn.offer(p);
        }
    }

    private int getUserInput(Player p) {
        printBoard();
        System.out.println(p.getPlayerName() + " Please enter a range between 1 and " + (boardSize*boardSize));
        int val = input.nextInt(); // catch value entered
        while(!validateInput(val)) { // check if number entered < 1 or > b*b and if entered number is already occupied
            printBoard();
            System.out.println("Wrong position: " + p.getPlayerName() + " Please enter a range between 1 and " + (boardSize*boardSize));
            val = input.nextInt(); // catch value entered
        }

        return val;
    }

    private boolean validateInput(int positionEntered) {
        if(positionEntered < 1 || positionEntered > (boardSize*boardSize)) return false;
        // convert position to a position in grid
        int row = 2*((positionEntered%boardSize == 0) ? (positionEntered/boardSize)-1 : (positionEntered/boardSize));
        int col = 2*((positionEntered%boardSize == 0) ? boardSize-1 : (positionEntered%boardSize)-1);
        if((int)board[row][col] != 0) {
            return false;
        }

        return true;
    }

    private boolean checkEndGame(Player p, int row, int col) { // player p when is at row, col -> check if game will end here
        String winString = "";
        for(int i=0; i<boardSize; i++) {
            winString += String.valueOf(p.getPlayerSymbol());
        }

        String rowString = "", colString = "", diagnolString = "", reverseDiagnolString = "";
        for(int i=0; i<board.length; i = i+2) {
            rowString += board[row][i];
            colString += board[i][col];
            if(row == col) {
                diagnolString += board[i][i];
            }
            if((row+col) == boardSize-1) {
                reverseDiagnolString += board[board.length-1-i][i];
            }
        }

        if(winString.equals(rowString) || winString.equals(colString) || winString.equals(diagnolString) || winString.equals(reverseDiagnolString)) {
            System.out.println(p.getPlayerName() + " has won the game!!");
            return true;
        }

        return false;
    }
}
