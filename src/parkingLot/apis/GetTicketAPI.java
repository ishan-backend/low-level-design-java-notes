package parkingLot.apis;

import parkingLot.data.ParkingSpot;
import parkingLot.data.Ticket;
import parkingLot.data.Vehicle;
import parkingLot.ticket.TicketGenerator;

public class GetTicketAPI {
    public Ticket getTicket(Vehicle vehicle, ParkingSpot parkingSpot) {
        // we always need to create underlying class to an API class to help it out
        // TicketGenerator class
        return new TicketGenerator().generateTicket(vehicle, parkingSpot);
    }
}
