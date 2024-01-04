package parkingLot.parkingFee;

import parkingLot.data.Ticket;
import parkingLot.payment.IPaymentProcessor;
import parkingLot.vehicleManager.VehicleTypeManagerFactory;

public class ParkingFeeProcessor {
    public double getParkingFees(Ticket ticket) {
        double duration = 0;
        // DB query to fetch time for which user was there in parking spot /  When you fetch Vehicle from DB, automatically entryTime will be fetched
        // OR, Ticket ->  Vehicle -> entryTime
        // figure out duration

        // get vehicle type of vehicle, and pass it to manager to get the parkingFees
        return VehicleTypeManagerFactory.getVehicleTypeManager(ticket.getVehicle().getVehicleType()).getParkingFees(duration);
    }

    // processParkingFees method can be called from anywhere, so before actually processing parking fee, check if there is not some random amount
    // match the fees from ticket with amount being paid
    public boolean processParkingFees(Ticket ticket, IPaymentProcessor paymentProcessor) {
        /*
            Strict Data Validation:
                - Some critical data from client like Payment data can't be trusted
                - add checks and validations for those
        */
        if(getParkingFees(ticket) != paymentProcessor.getAmount()) {
            throw new RuntimeException("invalid amount in processor does not match ticket price");
        }

        return paymentProcessor.executePayment();
    }
}
