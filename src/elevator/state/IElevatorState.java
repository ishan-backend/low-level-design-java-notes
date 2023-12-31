package elevator.state;

import elevator.data.Direction;
import elevator.data.ElevatorState;
import elevator.data.Floor;

public interface IElevatorState {
    void destiny(Floor floor, Direction direction);
    void open(Floor floor);
    void close(Floor floor);
    void stop(Floor floor);
    ElevatorState getStateName(); // returns string representation of current elevator state, which we might need to persist in DB or show in FE
}
