package parkingLot.apis;

import parkingLot.data.Ticket;
import parkingLot.parkingFee.ParkingFeeProcessor;

public class GetParkingFeeAPI {
    public double getParkingFee(Ticket ticket) {
        // uses underlying class ParkingFeeProcessor
        return new ParkingFeeProcessor().getParkingFees(ticket);
    }
}
