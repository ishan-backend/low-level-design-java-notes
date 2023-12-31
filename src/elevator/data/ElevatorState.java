package elevator.data;

public enum ElevatorState {
    IDLE,
    MOVING_UP,
    MOVING_DOWN,
    GATE_OPEN
}

/*
    State diagram: (Current State, API call, Next state, Notes)
     1. GATE_OPEN, DestinyElevatorAPI, MOVING_UP/MOVING_DOWN, Depending on the direction of floor
     2. MOVING_UP (to 11 th floor), DestinyElevatorAPI for floor 3, 14, 17 (Reaccess top priority floor), MOVING_UP/MOVING_DOWN
     3. " "
     4. MOVING_UP/MOVING_DOWN, StopElevatorAPI, IDLE
     5. GATE_OPEN, CloseGateAPI
     6. Pending requests and top priority requests (re-priortisation)
     7. No pending requests - stay in IDLE state

     In current algorithm, if lift is moving up, we will serve all top requests first
     But our state diagram is extensible to such scenarios as well
*/


