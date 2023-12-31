package elevator.state;

import elevator.data.Direction;
import elevator.data.ElevatorState;
import elevator.data.Floor;
import elevator.data.Move;
import elevator.elev.Elevator;

public class IdleState implements IElevatorState{
    private final Elevator elevator;

    public IdleState(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void destiny(Floor floor, Direction direction) {
        this.elevator.getMoveStore().addMove(new Move(floor, direction));
        Direction topMoveDirection = this.elevator.getMoveStore().getTopPriorityMove().get().getDestinationDirection(); // handle optional check later
        if(topMoveDirection.equals(Direction.UP)) {
            this.elevator.setElevatorState(new MovingUpState(this.elevator));
        } else if(topMoveDirection.equals(Direction.DOWN)) {
            this.elevator.setElevatorState(new MovingDownState(this.elevator));
        } else {
            throw new IllegalStateException();
        }
    }

    @Override
    public void open(Floor floor) {
        // log statements
        this.elevator.setElevatorState(new GateOpenState(this.elevator));
    }

    @Override
    public void close(Floor floor) {
        throw new RuntimeException();
    }

    @Override
    public void stop(Floor floor) {
        throw new RuntimeException();
    }

    @Override
    public ElevatorState getStateName() {
        return ElevatorState.IDLE;
    }
}
