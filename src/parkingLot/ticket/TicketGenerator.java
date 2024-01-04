package parkingLot.ticket;

import parkingLot.data.ParkingSpot;
import parkingLot.data.Ticket;
import parkingLot.data.Vehicle;

public class TicketGenerator {

    public synchronized Ticket generateTicket(Vehicle vehicle, ParkingSpot parkingSpot) {
        String ticketRefNum = generateUUID();

        // check if the parking spot is still free
        // then allocate it to particular vehicle using DB query

        // this code won't be thread safe on top of it, in multi-threaded system, due to context switch, some other thread also might access leading to race condition
        // can be avoided by acquiring lock
        // 1- use synchronized keyword 2- use locking at DB table level and get job done
        return new Ticket(ticketRefNum, vehicle, parkingSpot);
    }

    private String generateUUID() { // private hence called from inside this class only
        // logic is abstracted here
        return "";
    }
}
