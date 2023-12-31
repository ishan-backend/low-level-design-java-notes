package elevator.moves;

import elevator.data.Direction;
import elevator.data.Move;

import java.util.Optional;

// IMoveStore is referenced inside Elevator class
// IMoveStore is used by concrete implementations of IElevatorState, but since IMoveStore is referenced by Elevator
// Elevator has to be passed as reference to concrete implementations of IElevatorState
// so that they can call IMoveStore from concrete implementations of IElevatorState
public interface IMoveStore {
    void addMove(Move move); // addMove adds a move to list of moves
    Optional<Move> getTopPriorityMove();
    // getTopPriorityMove gives elevator top priority move / floor where it has to stop, when it is moving across floors/idle
    // just before touching a floor, this method is called
    // if all requests are served, then this function might not return anything, so its optional

    void clearTop(); // clearTop removes top priority request once it is served
    Direction getCurrentDirection(); // tells elevator the current directionENUM in which elevator is moving, this is polled by the API
}
