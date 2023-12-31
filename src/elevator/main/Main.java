package elevator.main;

import elevator.data.Direction;
import elevator.data.Floor;
import elevator.elev.Elevator;
import elevator.moves.UniDirectionalStore;
import elevator.state.IdleState;

public class Main {
    public static void main(String []args) {
        Elevator elevator = new Elevator(new UniDirectionalStore());
        elevator.setElevatorState(new IdleState(elevator));
        elevator.setCurrentFloor(new Floor(0, "Ground")); // we are at 0th floor
        System.out.println("Elevator at 0th floor " + elevator.getElevatorState().getStateName());
        elevator.open(new Floor(0, "Ground"));
        System.out.println("Passengers enter at 0th floor " + elevator.getElevatorState().getStateName());
        elevator.close(new Floor(0, "Ground")); // when close happens we check for direction where we have to go
        System.out.println("Gate Close at 0th floor " + elevator.getElevatorState().getStateName());


        elevator.destiny(new Floor(4, "Fourth"), Direction.UP); // 4th floor button press
        elevator.destiny(new Floor(7, "Seventh"), Direction.UP); // 7th floor button press
        System.out.println(elevator.getElevatorState().getStateName());
        elevator.setCurrentFloor(new Floor(1, "First")); // elevator reaching floor
        elevator.setCurrentFloor(new Floor(2, "Second"));
        elevator.setCurrentFloor(new Floor(3, "Third"));
        elevator.setCurrentFloor(new Floor(4, "Fourth"));
        elevator.stop(new Floor(4, "Fourth")); // elevator stopped at 4th floor
        System.out.println(elevator.getElevatorState().getStateName());
        elevator.open(new Floor(4, "Fourth"));
        System.out.println(elevator.getElevatorState().getStateName());
        elevator.close(new Floor(4, "Fourth"));
        System.out.println(elevator.getElevatorState().getStateName());
        elevator.destiny(new Floor(1, "First"), Direction.DOWN); // some other passenger enters, 1st floor command to come down while moving up to 7th floor
        elevator.setCurrentFloor(new Floor(7, "Seventh"));
        elevator.stop(new Floor(7, "Seventh")); // elevator stopped at 7th floor
        elevator.open(new Floor(7, "Seventh"));
        elevator.close(new Floor(7, "Seventh"));
        System.out.println(elevator.getElevatorState().getStateName());
    }
}
