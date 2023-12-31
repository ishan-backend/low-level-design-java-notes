package elevator.state;

import elevator.data.Direction;
import elevator.data.ElevatorState;
import elevator.data.Floor;
import elevator.elev.Elevator;

public class GateOpenState implements IElevatorState{
    private final Elevator elevator;

    public GateOpenState(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void destiny(Floor floor, Direction direction) {
        throw new RuntimeException();
    }

    @Override
    public void open(Floor floor) {
        throw new RuntimeException();
    }

    @Override
    public void close(Floor floor) {
        // When GATE_OPEN closes, we need to know top priority move from IMoveStore
        Direction direction = this.elevator.getMoveStore().getCurrentDirection();
        // Change state to returned direction
        if(direction.equals(Direction.UP)) {
            this.elevator.setElevatorState(new MovingUpState(this.elevator));
        } else if(direction.equals(Direction.DOWN)) {
            this.elevator.setElevatorState(new MovingDownState(this.elevator));
        } else if(direction.equals(Direction.HALT)) {
            this.elevator.setElevatorState(new IdleState(this.elevator));
        } else {
            // when handling ENUMS, we can throw unsupported exception
            throw new IllegalStateException();
        }
    }

    @Override
    public void stop(Floor floor) {
        throw new RuntimeException();
    }

    @Override
    public ElevatorState getStateName() {
        return ElevatorState.GATE_OPEN;
    }
}
