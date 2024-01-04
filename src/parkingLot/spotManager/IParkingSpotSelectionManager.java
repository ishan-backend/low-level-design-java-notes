package parkingLot.spotManager;

import parkingLot.data.ParkingSpot;

import java.util.List;

public interface IParkingSpotSelectionManager {
    ParkingSpot selectSpot(List<ParkingSpot> parkingSpotList);
}
