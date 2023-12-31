package elevator.elev;

import elevator.data.Direction;
import elevator.data.Floor;
import elevator.moves.IMoveStore;
import elevator.state.IElevatorState;

public class Elevator {
    private Floor currentFloor; // since this is not private, we need to have getter and setter

    /*
     states of elevator
     on basis of these states, we cannot allow it to have certain operations
     this appears to be ATM State design use-case, where we don't allow certain actions
    */
    private IElevatorState elevatorState; // abstraction + with getter and setter

    /*
        There is a complete logic to decide the current elevator state
        If there are multiple moves (button press actions), which move to serve on priority
        This logic may different for different strategies, so we need to decouple it from elevator
        And put it in interface IMoveStore - which can manage requests that elevator gets
    */
    private final IMoveStore moveStore; // since it is final, only getter; it is private final - use constructor

    public Elevator(IMoveStore moveStore) {
        this.moveStore = moveStore;
    }

    // below methods are for support of APIs
    public void destiny(Floor floor, Direction direction) {
        this.elevatorState.destiny(floor, direction);
    }

    public void open(Floor floor) {
        this.elevatorState.open(floor);
    }

    public void close(Floor floor) {
        this.elevatorState.close(floor);
    }

    public void stop(Floor floor) {
        this.elevatorState.stop(floor);
    }


    // keep getters and setters at bottom
    public Floor getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(Floor currentFloor) {
        this.currentFloor = currentFloor;
    }

    public IElevatorState getElevatorState() {
        return elevatorState;
    }

    public void setElevatorState(IElevatorState elevatorState) {
        this.elevatorState = elevatorState;
    }

    public IMoveStore getMoveStore() {
        return moveStore;
    }
}
