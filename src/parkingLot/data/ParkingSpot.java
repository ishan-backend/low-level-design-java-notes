package parkingLot.data;

public class ParkingSpot {
    private final String floorNumber;
    private final VehicleType vehicleType; // which can be parked at this spot
    private final String name;
    private final boolean isFree;


    public ParkingSpot(String floorNumber, VehicleType vehicleType, String name, boolean isFree) {
        this.floorNumber = floorNumber;
        this.vehicleType = vehicleType;
        this.name = name;
        this.isFree = isFree;
    }

    public boolean isFree() {
        return isFree;
    }

    public String getName() {
        return name;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getFloorNumber() {
        return floorNumber;
    }
}
