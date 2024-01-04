package parkingLot.spotFinderStrategy;

import parkingLot.data.ParkingSpot;
import parkingLot.spotManager.IParkingSpotSelectionManager;
import parkingLot.vehicleManager.IVehicleTypeManager;

import java.util.List;

// Strategy pattern - ParkingSpotFinder works using method findParkingSpot on basis of what entities were injected
// Ambient to OCP (wont need to change code often), DIP
public class ParkingSpotFinder {
    private final IVehicleTypeManager vehicleTypeManager;
    private final IParkingSpotSelectionManager spotSelectionManager;

    public ParkingSpotFinder(IVehicleTypeManager vehicleTypeManager, IParkingSpotSelectionManager spotSelectionManager) {
        this.vehicleTypeManager = vehicleTypeManager;
        this.spotSelectionManager = spotSelectionManager;
    }

    public ParkingSpot findParkingSpot() {
        List<ParkingSpot> parkingSpots = this.vehicleTypeManager.GetParkingSpots();
        return this.spotSelectionManager.selectSpot(parkingSpots);
    }
}
