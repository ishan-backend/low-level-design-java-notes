package elevator.state;

import elevator.data.Direction;
import elevator.data.ElevatorState;
import elevator.data.Floor;
import elevator.data.Move;
import elevator.elev.Elevator;

public class MovingUpState implements IElevatorState{
    private final Elevator elevator;

    public MovingUpState(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void destiny(Floor floor, Direction direction) {
        // while elevator is moving up, new request came
        this.elevator.getMoveStore().addMove(new Move(floor, direction));

        // if algorithm is not unidirectional only, we need to suddenly change direction (which is handled by IMoveStore and is set in Elevator)
        // on basis of topMoveDirection of Elevator, we change the elevator currentDirection
        Direction topMoveDirection = this.elevator.getMoveStore().getTopPriorityMove().get().getDestinationDirection(); // handle optional check later
        if(topMoveDirection.equals(Direction.DOWN)) {
            this.elevator.setElevatorState(new MovingDownState(this.elevator));
        }
    }

    @Override
    public void open(Floor floor) {
        throw new RuntimeException();
    }

    @Override
    public void close(Floor floor) {
        throw new RuntimeException();
    }

    @Override
    public void stop(Floor floor) {
        // log statements
        this.elevator.getMoveStore().clearTop();
        this.elevator.setElevatorState(new IdleState(this.elevator));
    }

    @Override
    public ElevatorState getStateName() {
        return ElevatorState.MOVING_UP;
    }
}
