package parkingLot.spotManager;

import parkingLot.data.EntryPoint;
import parkingLot.data.ParkingSpot;

import java.util.List;

public class NearestParkingSpotSelector implements IParkingSpotSelectionManager{
    private final EntryPoint entryPoint;

    public NearestParkingSpotSelector(EntryPoint entryPoint) {
        this.entryPoint = entryPoint;
    }

    @Override
    public ParkingSpot selectSpot(List<ParkingSpot> parkingSpotList) {
        return null;
    }

    public EntryPoint getEntryPoint() {
        return entryPoint;
    }
}
