package elevator.data;

public class Move {
    private final Floor destinationFloor;
    private final Direction destinationDirection;

    public Move(Floor floor, Direction direction) {
        this.destinationFloor = floor;
        this.destinationDirection = direction;
    }

    public Direction getDestinationDirection() {
        return destinationDirection;
    }

    public Floor getDestinationFloor() {
        return destinationFloor;
    }
}
