package parkingLot.vehicleManager;

import parkingLot.data.ParkingSpot;

import java.util.List;

public interface IVehicleTypeManager {
    List<ParkingSpot> GetParkingSpots();
    double getParkingFees(double durationHours);
}
