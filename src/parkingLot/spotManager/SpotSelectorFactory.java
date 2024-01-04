package parkingLot.spotManager;

import parkingLot.data.EntryPoint;

public class SpotSelectorFactory {
    private SpotSelectorFactory(){}

    // this factory is different from Vehicle Manager, since here for nearestSpotSelector we need an argument, so we create two public static methods
    public static IParkingSpotSelectionManager getNearestSpotSelector(EntryPoint entryPoint) {
        return new NearestParkingSpotSelector(entryPoint);
    }

    public static IParkingSpotSelectionManager getRandomSpotSelector() {
        return new RandomParkingSpotSelector();
    }
}
