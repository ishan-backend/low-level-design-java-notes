package elevator.moves;

import elevator.data.Direction;
import elevator.data.Move;

import java.util.Optional;
import java.util.PriorityQueue;

/*
     UniDirectionalStore - is concrete implementation of IMoveStore

     * Who will be using it?
     - It is used by concrete implementations of IElevatorState (State design pattern)
        - When destiny method is called in them, they will create a Move and add it to relevant IMoveStore

    * Ownership of IMoveStore?
    - lies with Elevator
    - concrete implementations of IElevatorState also reference to Elevator, in order to reference IMoveStore
*/
public class UniDirectionalStore implements IMoveStore{
    /*
        Thinking about data structure:
            e.g. current floor 3, moving up
            requests came in order - 15, 10, 16, 2

            since elevator is moving up, it will serve top requests first in order - 10, 15, 16
            then moving down, - 2

        minheap and maxheap are evident (priority queue)
    */

    private final PriorityQueue<Move> upMoves;
    private final PriorityQueue<Move> downMoves;
    private Direction currentDirection;

    // public constructor which initialises pq with comparator
    public UniDirectionalStore() {
        this.upMoves = new PriorityQueue<Move>(
                (f1, f2) -> f1.getDestinationFloor().getNumber() - f2.getDestinationFloor().getNumber()
        );
        this.downMoves = new PriorityQueue<Move>(
                (f1, f2) -> f2.getDestinationFloor().getNumber() - f1.getDestinationFloor().getNumber()
        );
        this.currentDirection = Direction.HALT;
    }

    @Override
    public void addMove(Move move) {
        if(this.upMoves.isEmpty() && this.downMoves.isEmpty()) {
            // this is first move, set direction to move
            this.currentDirection = move.getDestinationDirection();
        }

        if(move.getDestinationDirection().equals(Direction.UP)) {
            this.upMoves.add(move);
        } else {
            this.downMoves.add(move);
        }

        /*
            You may add re-prioritisation logic post addition of moves
        */

        // logic to change direction will be in clearTop()
    }

    @Override
    public Optional<Move> getTopPriorityMove() {
        if(this.upMoves.isEmpty() && this.downMoves.isEmpty())
            return Optional.empty();

        // check direction
        if(this.currentDirection.equals(Direction.UP)) {
            // find top move from upMoves priority queue
            return Optional.of(this.upMoves.peek());
        }
        return Optional.of(this.downMoves.peek());
    }

    @Override
    public void clearTop() {
        if(this.upMoves.isEmpty() && this.downMoves.isEmpty()) {
            throw new RuntimeException();
        }
        if(this.currentDirection.equals(Direction.UP)) {
            if(this.upMoves.isEmpty()) {
                throw new RuntimeException();
            }
            this.upMoves.poll(); // removes top most

            // check if you removed last one, check if any downward requests or not change state of elevator
            if(this.upMoves.isEmpty()) {
                if(!this.downMoves.isEmpty()) {
                    this.currentDirection = Direction.DOWN;
                } else {
                    this.currentDirection = Direction.HALT;
                }
            }

            // if upMoves is not empty elevator need not change its direction and can continue to move up
        } else {
            if(this.downMoves.isEmpty()) {
                throw new RuntimeException();
            }
            this.downMoves.poll(); // removes top most

            // check if you removed last one, check if any downward requests or not change state of elevator
            if(this.downMoves.isEmpty()) {
                if(!this.upMoves.isEmpty()) {
                    this.currentDirection = Direction.UP;
                } else {
                    this.currentDirection = Direction.HALT;
                }
            }

            // if downMoves is not empty elevator need not change its direction and can continue to move down
        }
    }

    @Override
    public Direction getCurrentDirection() {
        return this.currentDirection;
    }
}
