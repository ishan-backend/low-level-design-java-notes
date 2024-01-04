package parkingLot.data;

public class Ticket {
    private final String referenceNumber;
    private final Vehicle vehicle; // ticket generated for this vehicle
    private final ParkingSpot parkingSpot; // ticket generated for this vehicle for this spot

    public Ticket(String referenceNumber, Vehicle vehicle, ParkingSpot parkingSpot) {
        this.referenceNumber = referenceNumber;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }
}
