package elevator.state;

import elevator.data.Direction;
import elevator.data.ElevatorState;
import elevator.data.Floor;
import elevator.data.Move;
import elevator.elev.Elevator;

public class MovingDownState implements IElevatorState{
    private final Elevator elevator;

    public MovingDownState(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void destiny(Floor floor, Direction direction) {
        this.elevator.getMoveStore().addMove(new Move(floor, direction));
        // topMoveDirection is direction of topmost priority floor now
        Direction topMoveDirection = this.elevator.getMoveStore().getTopPriorityMove().get().getDestinationDirection(); // handle optional check later
        // if moving down floors will all be finished, then newDirection will be UP returned so change state of elevator instance
        if(topMoveDirection.equals(Direction.UP)) {
            this.elevator.setElevatorState(new MovingUpState(this.elevator));
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
        return ElevatorState.MOVING_DOWN;
    }
}
