package parkingLot.vehicleManager;

import parkingLot.data.ParkingSpot;

import java.util.List;

public class FourWheelerManager implements IVehicleTypeManager{
    @Override
    public List<ParkingSpot> GetParkingSpots() {
        return null;
    }

    @Override
    public double getParkingFees(double durationHours) {
        return 0;
    }
}
