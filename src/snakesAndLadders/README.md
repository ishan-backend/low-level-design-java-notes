https://leetcode.com/discuss/interview-question/4615686/PhonePe-or-SDE2-or-Machine-coding-Round-or-24-hours

**Mandatory Requirements:**

You have to take a configuration (can be a yaml/json file) with the following parameters:
* ● Number of players: N
* ● Board Size: BS (BS x BS)
* ● Number of Snakes: S
* ● Number of Ladders: L
* ● Number of Dies: D = 3 |  2 4 6

**DICE Strategy:**
  * Movement Strategy: MS
  * Note: Movement strategy is either:
      1. SUM (sum of numbers on dies), 
      2. MAX (max of numbers on dies), 
      3. MIN (min of number on dies).

**MOVE interface**:
  1. Snake (---
  2. Ladder (++
  3. Crocodile ( -5 )
  4. Normal Move( currPos + dice )

**Rules:**
* Snake always takes you to the cell where its tail is, and has to be a number less than
where you are at currently.
* Ladder takes you UP (strictly).
* If a player (A) comes to a cell where another player (B) is placed already, the previously
placed player (B) has to start again from 1.

**Optional Extensions:**
* Using the configuration you have to generate a random valid board & devise proper
rules for placing objects on the board.
* Write unit tests to validate all implemented functionality and their edge cases.
* Addition of special objects:
* Crocodile, which takes you exactly 5 steps back.
* Mine which holds you for 2 turns.

**Expectations:**
* Your code should cover all the functionality explained under “Mandatory Requirements”.
* You should implement at least one of “Optional Extensions”, preferably all.
* Implement a driver program which drives all above rules, and gives turns to players in a
round robin fashion to roll dies.
* Proper logging of all events, e.g rolling dies, movement to new cell, encountering
snakes/ladders etc.
* Code has to handle all edge cases
* Code should be modular enough to add further extensions or rules, without much
changes.
* A manual override must exist for the interviewer to verify the edge cases/ to write unit
tests. The program should take the following as input:
* Starting location of each player.
* The D die values that each player rolled in a turn.
Guidelines:
* The die roll can be implemented using a random function.

**Sample Input and Output:**

**Input format:**
```text
● Total Snakes S
● Following S lines contains pair (Snake’s Head and Snake’s Tail)
● Total Ladders L
● Following L lines contains pair (Ladder bottom and Ladder top)
● N no of players
● Following N lines contains names & starting locations of each Player
● An override to manually enter the D die values that each player rolled in each turn.
(Absent in example. Any input format is fine)

9
62 5
33 6
49 9
88 16
41 20
56 53
98 64
93 73
95 75
8
2 37
27 46
10 32
51 68
61 79
65 84
71 91
81 100
2
Gaurav 1
Sagar 1

Output:

Gaurav rolled a 6 and moved from 0 to 6
Sagar rolled a 1 and moved from 0 to 1
Gaurav rolled a 6 and moved from 6 to 12
Sagar rolled a 4 and moved from 1 to 5
Gaurav rolled a 4 and moved from 12 to 16
Sagar rolled a 6 and moved from 5 to 11
Gaurav rolled a 5 and moved from 16 to 21
Sagar rolled a 4 and moved from 11 to 15
Gaurav rolled a 1 and moved from 21 to 22


Sagar rolled a 6 and moved from 15 to 21
Gaurav rolled a 6 and moved from 22 to 28
Sagar rolled a 2 and moved from 21 to 23
Gaurav rolled a 6 and moved from 28 to 34
Sagar rolled a 6 and moved from 23 to 29
Gaurav rolled a 5 and moved from 34 to 39
Sagar rolled a 2 and moved from 29 to 31
Gaurav rolled a 2 and bitten by snake at 41 and moved from 41 to 20
Sagar rolled a 5 and moved from 31 to 36
Gaurav rolled a 3 and moved from 20 to 23
Sagar rolled a 5 and bitten by snake at 41 and moved from 41 to 20
Gaurav rolled a 6 and moved from 23 to 29
Sagar rolled a 3 and moved from 20 to 23
Gaurav rolled a 2 and moved from 29 to 31
Sagar rolled a 3 and moved from 23 to 26
Gaurav rolled a 3 and moved from 31 to 34
Sagar rolled a 5 and moved from 26 to 31
Gaurav rolled a 3 and moved from 34 to 37
Sagar rolled a 4 and moved from 31 to 35
Gaurav rolled a 2 and moved from 37 to 39
Sagar rolled a 5 and moved from 35 to 40
Gaurav rolled a 2 and bitten by snake at 41 and moved from 41 to 20
Sagar rolled a 5 and moved from 40 to 45
Gaurav rolled a 2 and moved from 20 to 22
Sagar rolled a 6 and climbed the ladder at 51 moved from 51 to 68
Gaurav rolled a 3 and moved from 22 to 25
Sagar rolled a 3 and climbed the ladder at 71 and moved from 71 to 91
Gaurav rolled a 5 and moved from 25 to 30
Sagar rolled a 2 and bitten by snake at 93 and moved from 93 to 73
Gaurav rolled a 5 and moved from 30 to 35
Sagar rolled a 6 and moved from 73 to 79
Gaurav rolled a 5 and moved from 35 to 40
Sagar rolled a 1 and moved from 79 to 80
Gaurav rolled a 4 and moved from 40 to 44
Sagar rolled a 2 and moved from 80 to 82
Gaurav rolled a 5 and bitten by snake at 49 and moved from 49 to 9
Sagar rolled a 4 and moved from 82 to 86
Gaurav rolled a 1 and climbed the ladder at 10 and moved from 10 to 32
Sagar rolled a 6 and moved from 86 to 92
Gaurav rolled a 3 and moved from 32 to 35


Sagar rolled a 4 and moved from 92 to 96
Gaurav rolled a 1 and moved from 35 to 36
Sagar rolled a 1 and moved from 96 to 97
Gaurav rolled a 1 and moved from 36 to 37
Sagar rolled a 5 and moved from 97 to 97
Gaurav rolled a 6 and moved from 36 to 42
Sagar rolled a 3 and moved from 97 to 100
```

How will you be evaluated
● Functional coverage
● Testability
● Application of OO design principles
● Code modularity, readability
● Separation of concerns

```java
import java.io.*;
import java.util.*;

/*
1
2
6
10
10
9
62 5
33 6
49 9
88 16
41 20
56 53
98 64
93 73
95 75
8
2 37
27 46
10 32
51 68
61 79
65 84
71 91
81 100
2
Gaurav 1
Sagar 1
*/

class Snake{
    int str;
    int end;
    public Snake(){

    }
    public Snake(int str,int end){
        this.str = str;
        this.end = end;
    }
    public void setStr(int str){
        this.str = str;
    }
    public int getStr(){
        return str;
    }
    public void setEnd(int end){
        this.end = end;
    }
    public int getEnd(){
        return end;
    }
}

class Ladder{
    int str;
    int end;
    public Ladder(int str,int end){
        this.str = str;
        this.end = end;
    }
    public void setStr(int str){
        this.str = str;
    }
    public int getStr(){
        return str;
    }
    public void setEnd(int end){
        this.end = end;
    }
    public int getEnd(){
        return end;
    }
}

class Dice{
    int num;
    int size;
    Random rand;
    public Dice(int num,int size){
        this.size = size;
        this.num = num;
        rand = new Random();
    }
    public int getMoves(){
        int steps = 0;
        for(int i=0;i<num;i++){
            int step= (int)(rand.nextInt()%size);
            while(step<=0){
                step = (int)(rand.nextInt()%size);
            }
            steps += step;
        }
        return steps;
    }
}

class Player{
    String name;
    Integer pos;
    public Player(String name,Integer pos){
        this.name = name;
        this.pos = pos;
    }

    public void setPos(int pos){
        this.pos = pos;
    }

    public int getPos(){
        return pos;
    }

    public String toString(){
        return name+" -> "+pos;
    }
}

class SnakeAndLadderGame{
    Dice dice;
    int winPos;
    Map<Integer,Integer> snakeMap;
    Map<Integer,Integer> ladderMap;
    Queue<Player> players = new LinkedList<>();
    public SnakeAndLadderGame(Dice dice,List<Snake> snake,List<Ladder> ladder,int n, int m){
        winPos = n*m;
        this.dice = dice;
        snakeMap = new HashMap<>();
        ladderMap = new HashMap<>();
        // Arrays.fill(ar,-1);
        for(int i=0;i<snake.size();i++){
            snakeMap.put(snake.get(i).getStr(),snake.get(i).getEnd());
        }
        for(int i=0;i<ladder.size();i++){
            ladderMap.put(ladder.get(i).getStr(),ladder.get(i).getEnd());
        }
        // System.out.println(Arrays.toString(ar));
    }
     public void addPlayer(Player player){
        players.add(player);
     }

     public boolean move(Player player){
        int steps = dice.getMoves();
        int nPos = player.getPos()+steps;
        if(nPos==winPos){
            System.out.println(player.name+" cur pos -> "+player.getPos()+" new pos -> "+nPos+" -> we got it");
            player.setPos(nPos);
            return true;
        }
        else if(nPos>winPos){
            System.out.println(player.name+" cur pos -> "+player.getPos()+" new pos -> "+nPos+" -> we cannot move");
            return false;
        }
        else{
            if(snakeMap.get(nPos)==null && ladderMap.get(nPos)==null){
                player.setPos(nPos);
                return false;
            }
            else if(snakeMap.get(nPos)!=null){
                player.setPos(snakeMap.get(nPos));  
                return false;
            }
            else if(ladderMap.get(nPos)!=null){
                player.setPos(ladderMap.get(nPos));  
                return false;
            }
        }
        return false;
     }

     public void start(){
        while(true){
            if(players.size()<=1){
                System.out.println("Required more than two people to play");
                return;
            }
            Player player = players.remove();

            if(move(player)==false){
                players.add(player);
            }
            else{
                System.out.println(player+" -> winner");
                return;
            }
        }
     }
}

public class Main {
    public static void main(String[] args) {
        try {
            System.setIn(new FileInputStream("input.txt"));
            System.setOut(new PrintStream(new FileOutputStream("output.txt")));
        } catch (Exception e) {
            System.err.println("Error");
        }
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            Dice dice = new Dice(n,k);
            int m1 = sc.nextInt();
            int m2 = sc.nextInt();

            List<Snake> snakes = new ArrayList<>();
            List<Ladder> ladders = new ArrayList<>();
            int s = sc.nextInt();
            for(int i=0;i<s;i++){
                int u = sc.nextInt();
                int v = sc.nextInt();
                snakes.add(new Snake(u,v));
            }
            int l = sc.nextInt();
            for(int i=0;i<l;i++){
                int u = sc.nextInt();
                int v = sc.nextInt();
                ladders.add(new Ladder(u,v));
            }
            int p =sc.nextInt();
            SnakeAndLadderGame snakeAndLadderGame = new SnakeAndLadderGame(dice,snakes,ladders,m1,m2);
            for(int i=0;i<p;i++){
                String name = sc.next();
                int pos = sc.nextInt();
                snakeAndLadderGame.addPlayer(new Player(name,pos));
            }
            snakeAndLadderGame.start();
        }
    }
}
```